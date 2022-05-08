package by.bsuir.fanficsbackend.service.validation;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.persistence.repository.UserRepository;
import by.bsuir.fanficsbackend.service.dto.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class UserValidator implements RestValidator {
    @Autowired
    private UserRepository repository;

    @Override
    public void validate(Object obj, AbstractEntity entity, Errors errors) {
        UserRequestDTO dto = (UserRequestDTO) obj;

        if (dto.getEmail() == null || dto.getEmail().isEmpty() || dto.getName() == null || dto.getName().isEmpty() ||
                dto.getPassword() == null || dto.getPassword().isEmpty()) {
            errors.reject("You must fill in name, password and email.");
            return;
        }

        if (repository.findByName(dto.getName()) != null || repository.findByEmail(dto.getEmail()) != null) {
            errors.reject("User with this name or email already exists.");
        }
    }

    @Override
    public Class<?> supports() {
        return UserRequestDTO.class;
    }
}
