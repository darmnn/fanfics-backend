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

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
    protected List<Predicate> buildSearchPredicates(BookSearchDTO dto, Root<Book> root) {
        return super.buildSearchPredicates(dto, root);
    }

    @Override
    public boolean hasUpdateAccess(Long id) {
        return false;
    }
}