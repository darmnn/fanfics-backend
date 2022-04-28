package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Chapter;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.service.dto.ChapterCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChapterRequestDTOAssembler extends AbstractRequestDTOAssembler<Chapter, ChapterCreateRequestDTO, ChapterUpdateRequestDTO> {
    @Autowired
    private BookRepository bookRepository;

    public ChapterRequestDTOAssembler() {
        super(Chapter.class, ChapterCreateRequestDTO.class, ChapterUpdateRequestDTO.class);
    }

    @Override
    protected void populateAdditionalFieldsForCreate(Chapter entity, ChapterCreateRequestDTO dto) {
        super.populateAdditionalFieldsForCreate(entity, dto);
    }
}
