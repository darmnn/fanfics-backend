package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.exception.ResourceNotFoundException;
import by.bsuir.fanficsbackend.exception.ValidationException;
import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.persistence.repository.CustomCrudRepository;
import by.bsuir.fanficsbackend.service.assembler.AbstractRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.AbstractResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.RequestDTO;
import by.bsuir.fanficsbackend.service.dto.ResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.validation.RestValidator;
import by.bsuir.fanficsbackend.service.validation.ValidatorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractCrudService<R extends ResponseDTO<R>, C extends RequestDTO, U extends RequestDTO,
        S extends SearchDTO, E extends AbstractEntity, M extends CustomCrudRepository<E>>
        extends AbstractReadService<R, S, E, M> implements CrudService<C, S, U, R>{
    private AbstractRequestDTOAssembler<E, C, U> requestAssembler;
    @Autowired
    private ValidatorRegistry validatorRegistry;

    protected AbstractCrudService(AbstractResponseDTOAssembler<E, R> responseAssembler,
                                  AbstractRequestDTOAssembler<E, C, U> requestAssembler, Class<E> entityClass) {
        super(responseAssembler, entityClass);
        this.requestAssembler = requestAssembler;
    }

    @Override
    public R create(C dto, BindingResult bindingResult) throws HttpRequestMethodNotSupportedException {
        E entity;
        try {
            entity = entityClass.getDeclaredConstructor().newInstance();
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw new RuntimeException("Error creating entity");
        }

        validateSave(dto, entity, bindingResult);

        entity = requestAssembler.toEntityCreate(dto, entity);

        entity = repository.save(entity);

        processAdditionalFieldForCreate(dto, entity);

        return responseAssembler.toModel(entity);
    }

    @Override
    public R patch(Long id, U dto) throws HttpRequestMethodNotSupportedException {
        return null;
    }

    @Override
    public void delete(Long id) {
        E entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No resource with ID " +
                id.toString()));
        repository.delete(entity);
    }

    private void validateSave(Object obj, E entity, BindingResult bindingResult) {
        RestValidator validator = validatorRegistry.getValidator(obj.getClass());
        validator.validate(obj, entity, bindingResult);
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult);
        }
    }

    protected void validateAdditionalFieldsOnSave(Object obj, E entity, BindingResult bindingResult) {
        // help method
    }

    protected void processAdditionalFieldForCreate(C dto, E entity) {
        // help method
    }

    protected void processAdditionalFieldForUpdate(U dto, E entity) {
        // help method
    }
}
