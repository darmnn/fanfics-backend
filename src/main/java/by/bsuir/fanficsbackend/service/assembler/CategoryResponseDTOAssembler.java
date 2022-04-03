package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Category;
import by.bsuir.fanficsbackend.service.dto.CategoryResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseDTOAssembler extends AbstractResponseDTOAssembler<Category, CategoryResponseDTO> {
    public CategoryResponseDTOAssembler() {
        super(CategoryResponseDTO.class, Category.class);
    }
}
