package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Tag;
import by.bsuir.fanficsbackend.service.dto.TagResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class TagResponseDTOAssembler extends AbstractResponseDTOAssembler<Tag, TagResponseDTO> {
    public TagResponseDTOAssembler() {
        super(TagResponseDTO.class, Tag.class);
    }
}
