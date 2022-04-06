package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.service.StubService;
import by.bsuir.fanficsbackend.service.dto.ResponseDTO;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public abstract class AbstractResponseDTOAssembler<E extends AbstractEntity, R extends ResponseDTO<R>>
        extends RepresentationModelAssemblerSupport<E, R> implements DTOAssembler {
    private final Class<E> entityType;

    protected AbstractResponseDTOAssembler(Class<R> responseDTOType, Class<E> entityType) {
        this(StubService.class, responseDTOType, entityType);
    }

    protected AbstractResponseDTOAssembler(Class<?> controllerClass, Class<R> responseDTOType, Class<E> entityType) {
        super(controllerClass, responseDTOType);
        this.entityType = entityType;
    }

    @Override
    public R toModel(E entity) {
        R dto = instantiateModel(entity);

        ReflectionUtils.doWithFields(getResponseType(), dtoFiled -> {
            String entityFiledName = getEntityFiledName(dtoFiled);
            Field entityField = ReflectionUtils.findField(entityType, entityFiledName);

            if (entityField != null) {
                Class<?> dtoFieldType = dtoFiled.getType();
                Object entityFieldValue = getFiledValue(entityField, entity);

                if (isResponseDTOType(dtoFieldType)) {
                    AbstractResponseDTOAssembler assembler = getResponseDTOAssembler(dtoFieldType);
                    AbstractEntity subEntity = (AbstractEntity) entityFieldValue;

                    if (subEntity != null) {
                        ResponseDTO subResource = (ResponseDTO)assembler.createModelWithId(subEntity.getId(), subEntity);
                        subResource.setId(subEntity.getId());
                        setFiledValue(dtoFiled, dto, subResource);
                    }
                }
                else {
                    setFiledValue(dtoFiled, dto, entityFieldValue);
                }
            }
        });

        populateAdditionalFields(dto, entity);

        return dto;
    }

    protected void populateAdditionalFields(R dto, E entity)
    {
        // helper method
    }

    /////////////////////////////////////////////
    //
    // Getters & setters
    //
    ////////////////////////////////////////////

    public Class<R> getResponseType() {
        return super.getResourceType();
    }

    protected AbstractResponseDTOAssembler<?, ?> getResponseDTOAssembler(Class<?> responseType) {
        return AssemblerRegistry.getResponseDTOAssembler((Class<ResponseDTO>) responseType);
    }
}
