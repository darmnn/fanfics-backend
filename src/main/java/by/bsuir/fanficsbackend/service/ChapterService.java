package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/chapters")
public interface ChapterService {
    @GetMapping("/{id}")
    @ResponseBody
    List<ChapterResponseDTO> get(@PathVariable Long id);
}
