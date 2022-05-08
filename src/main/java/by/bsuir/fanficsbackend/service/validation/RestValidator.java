package by.bsuir.fanficsbackend.service.validation;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import org.springframework.validation.Errors;

public interface RestValidator {
    void validate(Object obj, AbstractEntity entity, Errors errors);

    default void validate(Object obj, Errors errors) {
        validate(obj, null, errors);
    }

    Class<?> supports();
}
