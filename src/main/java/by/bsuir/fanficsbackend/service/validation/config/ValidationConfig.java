package by.bsuir.fanficsbackend.service.validation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ValidationConfig {
    @Bean
    public SpringValidatorAdapter springValidatorAdapter() {
        return new SpringValidatorAdapter(validator());
    }

    @Bean
    public Validator validator() {
        return Validation.byDefaultProvider().configure().messageInterpolator(messageInterpolator()).buildValidatorFactory().getValidator();
    }

    @Bean
    public MessageInterpolator messageInterpolator() {
        return Validation.byDefaultProvider().configure().getDefaultMessageInterpolator();
    }
}
