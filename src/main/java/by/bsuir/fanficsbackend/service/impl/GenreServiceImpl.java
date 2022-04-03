package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Genre;
import by.bsuir.fanficsbackend.persistence.repository.GenreRepository;
import by.bsuir.fanficsbackend.service.AbstractReadService;
import by.bsuir.fanficsbackend.service.GenreService;
import by.bsuir.fanficsbackend.service.assembler.GenreResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.GenreResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreServiceImpl extends AbstractReadService<GenreResponseDTO, SearchDTO, Genre, GenreRepository>
        implements GenreService {
    @Autowired
    public GenreServiceImpl(GenreResponseDTOAssembler responseAssembler) {
        super(responseAssembler, Genre.class);
    }
}
