package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Book;
import by.bsuir.fanficsbackend.persistence.entity.BookTagMap;
import by.bsuir.fanficsbackend.persistence.entity.Tag;
import by.bsuir.fanficsbackend.persistence.repository.BookTagMapRepository;
import by.bsuir.fanficsbackend.service.dto.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookResponseDTOAssembler extends AbstractResponseDTOAssembler<Book, BookResponseDTO> {
    @Autowired
    private BookTagMapRepository bookTagMapRepository;
    @Autowired
    private TagResponseDTOAssembler tagResponseAssembler;

    public BookResponseDTOAssembler() {
        super(BookResponseDTO.class, Book.class);
    }

    @Override
    protected void populateAdditionalFields(BookResponseDTO dto, Book entity) {
        List<Tag> tags = bookTagMapRepository.findByBookId(entity.getId()).stream().map(t -> t.getTag()).collect(Collectors.toList());
        dto.setTags(tags.stream().map(t -> tagResponseAssembler.toModel(t)).collect(Collectors.toList()));
    }
}
