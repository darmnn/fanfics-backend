package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Book;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.service.AbstractReadService;
import by.bsuir.fanficsbackend.service.BookService;
import by.bsuir.fanficsbackend.service.assembler.BookResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookServiceImpl extends AbstractReadService<BookResponseDTO, SearchDTO, Book, BookRepository>
        implements BookService {
    private static final int RECENT_WORKS_LIMIT = 15;

    @Autowired
    protected BookServiceImpl(BookResponseDTOAssembler responseAssembler) {
        super(responseAssembler, Book.class);
    }

    @Override
    public List<BookResponseDTO> getRecentWorks() {
        List<BookResponseDTO> allWorks = search(null);
        Comparator<BookResponseDTO> worksComparator = Comparator.comparing(BookResponseDTO::getRating);
        Collections.sort(allWorks, worksComparator);

        return allWorks.stream().limit(RECENT_WORKS_LIMIT).collect(Collectors.toList());
    }
}