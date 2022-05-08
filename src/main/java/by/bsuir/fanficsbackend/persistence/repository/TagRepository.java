package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.Tag;

import java.util.Optional;

public interface TagRepository extends CustomCrudRepository<Tag>{
    Optional<Tag> findByName(String name);
}
