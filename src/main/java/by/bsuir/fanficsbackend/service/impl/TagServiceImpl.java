package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Tag;
import by.bsuir.fanficsbackend.persistence.repository.TagRepository;
import by.bsuir.fanficsbackend.service.AbstractReadService;
import by.bsuir.fanficsbackend.service.TagService;
import by.bsuir.fanficsbackend.service.assembler.TagResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.TagResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagServiceImpl extends AbstractReadService<TagResponseDTO, SearchDTO, Tag, TagRepository>
        implements TagService {
    @Autowired
    public TagServiceImpl(TagResponseDTOAssembler responseAssembler) {
        super(responseAssembler, Tag.class);
    }
}
