package by.bsuir.fanficsbackend.service.validation;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.service.dto.ChapterCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.CommentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class ChapterValidator implements RestValidator {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void validate(Object obj, AbstractEntity entity, Errors errors) {
        ChapterCreateRequestDTO dto = (ChapterCreateRequestDTO) obj;

        if (dto.getText() == null || dto.getText().isEmpty() || dto.getNumber() == null || dto.getName() == null ||
                dto.getName().isEmpty() || dto.getBookId() == null) {
            errors.reject("You must provide number, name, text and book to post a chapter.");
            return;
        }

        if (!bookRepository.existsById(dto.getBookId())) {
            errors.reject("This book doesn't exist.");
        }
    }

    @Override
    public Class<?> supports() {
        return ChapterCreateRequestDTO.class;
    }
}
