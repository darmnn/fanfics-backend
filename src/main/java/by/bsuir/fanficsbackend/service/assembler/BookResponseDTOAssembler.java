package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Book;
import by.bsuir.fanficsbackend.service.dto.BookResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class BookResponseDTOAssembler extends AbstractResponseDTOAssembler<Book, BookResponseDTO> {
    public BookResponseDTOAssembler() {
        super(BookResponseDTO.class, Book.class);
    }
}
