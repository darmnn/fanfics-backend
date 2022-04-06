package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.CategoryResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/categories")
public interface CategoryService extends ReadService<CategoryResponseDTO, SearchDTO> {
}
