package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.GenreResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/genres")
public interface GenreService extends ReadService<GenreResponseDTO, SearchDTO> {
}
