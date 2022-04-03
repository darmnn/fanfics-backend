package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.TagResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tag")
public interface TagService extends ReadService<TagResponseDTO, SearchDTO> {
}
