package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.service.dto.RequestDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class AbstractRequestDTOAssembler<E extends AbstractEntity, C extends RequestDTO, U extends RequestDTO>
        implements DTOAssembler {
    private final Class<E> entityType;
    private final Class<C> createDTOType;
    private final Class<U> updateDTOType;

    @Autowired
    protected EntityManager entityManager;

    protected AbstractRequestDTOAssembler(Class<E> entityType, Class<C> createDTOType, Class<U> updateDTOType) {
        this.entityType = entityType;
        this.createDTOType = createDTOType;
        this.updateDTOType = updateDTOType;
    }

    public E toEntityUpdate(U dto, E entity) {
        processEntityFields(dto, entity);
        populateAdditionalFieldsForUpdate(entity, dto);
        return entity;
    }

    protected void populateAdditionalFieldsForUpdate(E entity, U dto) {
        // help method
    }

    public E toEntityCreate(C dto, E entity) {
        processEntityFields(dto, entity);
        populateAdditionalFieldsForCreate(entity, dto);
        return entity;
    }

    protected void populateAdditionalFieldsForCreate(E entity, C dto) {
        // help method
    }

    public U updateResource(E entity, U dto) {
        U entityDto = toUpdateDTO(entity);
        Map<String, Object> updateFields = getUpdateFields();

        processResourceFields(dto, entityDto, updateFields);

        return entityDto;
    }

    protected void processResourceFields(U dto, U entityDto, Map<String, Object> updateFields) {

    }

    public U toUpdateDTO(E entity) {
        return null;
    }

    protected void populateAdditionalUpdateDtoFields(U dto, E entity) {
        //help method
    }

    protected AbstractRequestDTOAssembler<?, ?, ?> getCreateRequestDtoAssembler(Class<?> createRequestDtoType) {
        return AssemblerRegistry.getCreateRequestDtoAssembler(createDTOType);
    }

    protected AbstractRequestDTOAssembler<?, ?, ?> getUpdateRequestDtoAssembler(Class<?> updateRequestDtoType) {
        return AssemblerRegistry.getUpdateRequestDtoAssembler(updateDTOType);
    }

    private Object getEntityFieldValue(E entity, Field entityField, Object dtoFieldValue) {
        return null;
    }

    private Object findEntityById(Class<AbstractEntity> entityFieldType, Long entityId) {
        return null;
    }

    private Map<String, Object> getUpdateFields() {
        return null;
    }

    private void processEntityFields(Object dto, E entity) {

    }

    public Class<C> getCreateDTOType() {
        return createDTOType;
    }

    public Class<U> getUpdateDTOType() {
        return updateDTOType;
    }


}

