package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.persistence.repository.CustomCrudRepository;
import by.bsuir.fanficsbackend.service.assembler.AbstractResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.ResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractReadService<R extends ResponseDTO<R>, S extends SearchDTO, E extends AbstractEntity, C extends CustomCrudRepository<E>>
        implements ReadService<R, S> {
    protected AbstractResponseDTOAssembler<E, R> responseAssembler;
    protected Class<E> entityClass;

    @Autowired
    protected C repository;
    @Autowired
    protected EntityManager entityManager;

    protected AbstractReadService(AbstractResponseDTOAssembler<E, R> responseAssembler, Class<E> entityClass) {
        this.responseAssembler = responseAssembler;
        this.entityClass = entityClass;
    }

    @Override
    public R get(Long id) {
        Optional<E> optionalEntity = repository.findById(id);
        E entity = optionalEntity.orElseThrow(() -> new RuntimeException());
        return responseAssembler.toModel(entity);
    }

    @Override
    public List<R> search(S dto) {
        List<E> entities = new ArrayList<>();

        if (dto != null) {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<E> criteriaQuery = criteriaBuilder.createQuery(entityClass);

            Root<E> root = criteriaQuery.from(entityClass);
            List<Predicate> predicates = new ArrayList<>();
            predicates.addAll(buildSearchPredicates(dto, root));
            Predicate[] predicateArray = predicates.toArray(new Predicate[]{});

            criteriaQuery.where(criteriaBuilder.and(predicateArray));

            TypedQuery<E> typedQuery = entityManager.createQuery(criteriaQuery);

            entities = typedQuery.getResultList();
        }
        else {
            repository.findAll().forEach(entities::add);
        }

        return entities.stream().map(e -> responseAssembler.toModel(e)).collect(Collectors.toList());
    }

    protected List<Predicate> buildSearchPredicates(S dto, Root<E> root) {
        return Collections.emptyList();
    }
}
