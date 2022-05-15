package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.exception.ResourceNotFoundException;
import by.bsuir.fanficsbackend.persistence.entity.*;
import by.bsuir.fanficsbackend.persistence.repository.*;
import by.bsuir.fanficsbackend.service.AbstractCrudService;
import by.bsuir.fanficsbackend.service.BookService;
import by.bsuir.fanficsbackend.service.assembler.BookRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.BookResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.BookCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.BookResponseDTO;
import by.bsuir.fanficsbackend.service.dto.BookSearchDTO;
import by.bsuir.fanficsbackend.service.dto.BookUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookServiceImpl extends AbstractCrudService<BookResponseDTO, BookCreateRequestDTO, BookUpdateRequestDTO,
        BookSearchDTO, Book, BookRepository>
        implements BookService {
    private static final int RECENT_WORKS_LIMIT = 15;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private FandomRepository fandomRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private BookTagMapRepository bookTagMapRepository;

    @Autowired
    protected BookServiceImpl(BookResponseDTOAssembler responseAssembler, BookRequestDTOAssembler requestAssembler) {
        super(responseAssembler, requestAssembler, Book.class);
    }

    @Override
    public List<BookResponseDTO> getRecentWorks() {
        List<BookResponseDTO> allWorks = search(null);
        Comparator<BookResponseDTO> worksComparator = Comparator.comparing(BookResponseDTO::getRating);
        Collections.sort(allWorks, worksComparator);

        return allWorks.stream().limit(RECENT_WORKS_LIMIT).collect(Collectors.toList());
    }

    @Override
    public List<BookResponseDTO> search(Long fandom, Long category, Long genre, Long user, Long tag) {
        BookSearchDTO bookSearchDTO = new BookSearchDTO();
        if (fandom != null) {
            bookSearchDTO.setFandomId(fandom);
        }
        if (category != null) {
            bookSearchDTO.setCategoryId(category);
        }
        if (genre != null) {
            bookSearchDTO.setGenreId(genre);
        }
        if (user != null) {
            bookSearchDTO.setUserId(user);
        }

        List<BookResponseDTO> books = this.searchByParams(bookSearchDTO);

        if (tag != null) {
            List<Book> taggedBooks = repository.findByTag(tag);
            List<BookResponseDTO> taggedBooksResponseDTOs = taggedBooks.stream().map(tb -> responseAssembler.toModel(tb))
                    .collect(Collectors.toList());
            return taggedBooksResponseDTOs;
        } else {
            return books;
        }
    }

    @Override
    protected List<Predicate> buildSearchPredicates(BookSearchDTO dto, Root<Book> root) {
        List<Predicate> predicates = new ArrayList<>();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        if (dto.getFandomId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("fandom").get("id"), dto.getFandomId()));
        }
        if (dto.getCategoryId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("category").get("id"), dto.getCategoryId()));
        }
        if (dto.getGenreId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("genre").get("id"), dto.getGenreId()));
        }
        if (dto.getUserId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("user").get("id"), dto.getUserId()));
        }

        return predicates;
    }

    @Override
    public BookResponseDTO patch(Long id, BookUpdateRequestDTO dto) throws HttpRequestMethodNotSupportedException {
        Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found with ID "
                + id.toString()));

        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getGenreId() != null) {
            Genre genre = genreRepository.findById(dto.getGenreId()).orElseThrow(() ->
                    new ResourceNotFoundException("No genre with ID" + dto.getGenreId().toString()));
            entity.setGenre(genre);
        }
        if (dto.getFandomId() != null) {
            Fandom fandom = fandomRepository.findById(dto.getFandomId()).orElseThrow(() ->
                    new ResourceNotFoundException("No fandom with ID" + dto.getFandomId().toString()));
            entity.setFandom(fandom);
        }
        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() ->
                    new ResourceNotFoundException("No category with ID" + dto.getCategoryId().toString()));
            entity.setCategory(category);
        }
        if (dto.getTags() != null) {
            for (String tag : dto.getTags()) {
                BookTagMap bookTagMap = new BookTagMap();
                bookTagMap.setBook(entity);

                if (tagRepository.findByName(tag).isPresent()) {
                    Tag tagEntity = tagRepository.findByName(tag).get();
                    bookTagMap.setTag(tagEntity);

                    if (!bookTagMapRepository.findByBookIdAndTagId(entity.getId(), tagEntity.getId()).isPresent()) {
                        bookTagMapRepository.save(bookTagMap);
                    }
                }
                else {
                    Tag tagEntity = new Tag();
                    tagEntity.setName(tag);
                    bookTagMap.setTag(tagEntity);
                    bookTagMapRepository.save(bookTagMap);
                }
            }
        }
        repository.save(entity);

        return responseAssembler.toModel(entity);
    }

    @Override
    public boolean hasUpdateAccess(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            User user = userRepository.findByName(currentUserName);
            Book book = repository.findById(id).orElseThrow();

            return book.getUser().equals(user);
        } else {
            return false;
        }
    }

    @Override
    public void like(Long id) {
        Book entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found with ID "
                + id.toString()));
        entity.setLikes(entity.getLikes() + 1);

        if (entity.getLikes() < 15) {
            entity.setRating(1);
        }
        else if (entity.getLikes() >= 15 && entity.getLikes() < 30) {
            entity.setRating(2);
        }
        else if (entity.getLikes() >= 30 && entity.getLikes() < 50) {
            entity.setRating(3);
        }
        else if (entity.getLikes() >= 50 && entity.getLikes() < 100) {
            entity.setRating(4);
        }
        else if (entity.getLikes() >= 100) {
            entity.setRating(5);
        }

        repository.save(entity);
    }
}