package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Fandom;
import by.bsuir.fanficsbackend.persistence.repository.FandomRepository;
import by.bsuir.fanficsbackend.service.AbstractReadService;
import by.bsuir.fanficsbackend.service.FandomService;
import by.bsuir.fanficsbackend.service.assembler.FandomResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.FandomResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FandomServiceImpl extends AbstractReadService<FandomResponseDTO, SearchDTO, Fandom, FandomRepository>
        implements FandomService {
    @Autowired
    public FandomServiceImpl(FandomResponseDTOAssembler responseAssembler) {
        super(responseAssembler, Fandom.class);
    }
}
