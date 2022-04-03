package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Genre;
import by.bsuir.fanficsbackend.service.dto.GenreResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class GenreResponseDTOAssembler extends AbstractResponseDTOAssembler<Genre, GenreResponseDTO> {
    public GenreResponseDTOAssembler() {
        super(GenreResponseDTO.class, Genre.class);
    }
}
