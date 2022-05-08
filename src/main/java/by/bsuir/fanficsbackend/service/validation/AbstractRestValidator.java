package by.bsuir.fanficsbackend.service.validation;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.service.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

@Component
public class AbstractRestValidator implements RestValidator {
    @Autowired
    private SpringValidatorAdapter springValidator;

    @Override
    public void validate(Object obj, AbstractEntity entity, Errors errors) {
        springValidator.validate(obj, errors);
    }

    @Override
    public Class<?> supports() {
        return RequestDTO.class;
    }
}
