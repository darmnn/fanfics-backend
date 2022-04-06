package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterSearchDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/chapters")
public interface ChapterService extends ReadService<ChapterResponseDTO, ChapterSearchDTO> {
}
