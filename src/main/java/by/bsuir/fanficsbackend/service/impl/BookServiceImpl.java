package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Book;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.service.AbstractCrudService;
import by.bsuir.fanficsbackend.service.BookService;
import by.bsuir.fanficsbackend.service.assembler.BookRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.BookResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.BookCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.BookResponseDTO;
import by.bsuir.fanficsbackend.service.dto.BookSearchDTO;
import by.bsuir.fanficsbackend.service.dto.BookUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<BookResponseDTO> search(Long fandom, Long category, Long genre, Long user) {
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
        return this.searchByParams(bookSearchDTO);
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
        if (dto.getGenreId()!= null) {
            predicates.add(criteriaBuilder.equal(root.get("genre").get("id"), dto.getGenreId()));
        }
        if (dto.getUserId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("user").get("id"), dto.getFandomId()));
        }

        return predicates;
    }

    @Override
    public boolean hasUpdateAccess(Long id) {
        return false;
    }
}