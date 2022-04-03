package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Chapter;
import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ChapterResponseDTOAssembler extends AbstractResponseDTOAssembler<Chapter, ChapterResponseDTO> {
    public ChapterResponseDTOAssembler() {
        super(ChapterResponseDTO.class, Chapter.class);
    }
}
