package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.ChapterCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterSearchDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterUpdateRequestDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/chapters")
public interface ChapterService extends CrudService<ChapterCreateRequestDTO, ChapterSearchDTO, ChapterUpdateRequestDTO, ChapterResponseDTO>{
    @GetMapping("/book/{id}")
    @ResponseBody
    List<ChapterResponseDTO> getBookChapters(@PathVariable Long id);
}
