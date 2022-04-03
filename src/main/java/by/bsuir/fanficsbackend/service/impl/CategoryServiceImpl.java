package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Category;
import by.bsuir.fanficsbackend.persistence.repository.CategoryRepository;
import by.bsuir.fanficsbackend.service.AbstractReadService;
import by.bsuir.fanficsbackend.service.CategoryService;
import by.bsuir.fanficsbackend.service.assembler.CategoryResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.CategoryResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryServiceImpl extends AbstractReadService<CategoryResponseDTO, SearchDTO, Category,
        CategoryRepository> implements CategoryService {
    @Autowired
    public CategoryServiceImpl(CategoryResponseDTOAssembler responseAssembler) {
        super(responseAssembler, Category.class);
    }
}
