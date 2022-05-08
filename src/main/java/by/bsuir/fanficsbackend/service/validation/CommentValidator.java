package by.bsuir.fanficsbackend.service.validation;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.persistence.repository.UserRepository;
import by.bsuir.fanficsbackend.service.dto.CommentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class CommentValidator implements RestValidator {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(Object obj, AbstractEntity entity, Errors errors) {
        CommentRequestDTO dto = (CommentRequestDTO) obj;

        if (dto.getText() == null || dto.getText().isEmpty() || dto.getUserId() == null || dto.getBookId() == null) {
            errors.reject("You must provide text, user and book to leave a comment.");
            return;
        }

        if (!bookRepository.existsById(dto.getBookId())) {
            errors.reject("This book doesn't exist.");
        }

        if (!userRepository.existsById(dto.getUserId())) {
            errors.reject("This user doesn't exist.");
        }
    }

    @Override
    public Class<?> supports() {
        return CommentRequestDTO.class;
    }
}
