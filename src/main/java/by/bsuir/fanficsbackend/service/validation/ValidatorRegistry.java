package by.bsuir.fanficsbackend.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ValidatorRegistry {
    private final Map<Class<?>, RestValidator> validatorsMap = new HashMap<>();
    @Autowired
    private RestValidator abstractRestValidator;

    @Autowired
    public ValidatorRegistry(List<RestValidator>validators) {
        validators.forEach(validator -> validatorsMap.putIfAbsent(validator.supports(), validator));
    }

    public RestValidator getValidator(Class<?> dtoType) {
        return validatorsMap.getOrDefault(dtoType, getDefaultRestValidator());
    }

    public RestValidator getDefaultRestValidator() {
        return abstractRestValidator;
    }
}
