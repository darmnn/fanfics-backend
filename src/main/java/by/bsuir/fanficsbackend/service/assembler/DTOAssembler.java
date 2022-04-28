package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.service.dto.RequestDTO;
import by.bsuir.fanficsbackend.service.dto.ResponseDTO;

import java.lang.reflect.Field;

public interface DTOAssembler {
    default boolean isResponseDTOType(Class<?> clazz) {
        return ResponseDTO.class.isAssignableFrom(clazz);
    }

    default Object getFiledValue(Field field, Object o) {
        try {
            field.setAccessible(true);
            return field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error getting field value", e);
        }
    }

    default void setFiledValue(Field field, Object o, Object value) {
        try {
            field.setAccessible(true);
            field.set(o, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error setting field value", e);
        }
    }

    default String getEntityFiledName(Field dtoField) {
        return dtoField.getName();
    }
}
