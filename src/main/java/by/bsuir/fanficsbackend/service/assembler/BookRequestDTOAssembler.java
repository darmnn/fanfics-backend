package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Book;
import by.bsuir.fanficsbackend.persistence.repository.*;
import by.bsuir.fanficsbackend.service.dto.BookCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.BookUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookRequestDTOAssembler extends AbstractRequestDTOAssembler<Book, BookCreateRequestDTO, BookUpdateRequestDTO> {
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private FandomRepository fandomRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BookTagMapRepository bookTagMapRepository;

    public BookRequestDTOAssembler(){
        super(Book.class, BookCreateRequestDTO.class, BookUpdateRequestDTO.class);
    }

    @Override
    protected void populateAdditionalFieldsForUpdate(Book entity, BookUpdateRequestDTO dto) {
        super.populateAdditionalFieldsForUpdate(entity, dto);
    }

    @Override
    protected void populateAdditionalFieldsForCreate(Book entity, BookCreateRequestDTO dto) {
        super.populateAdditionalFieldsForCreate(entity, dto);
    }
}
