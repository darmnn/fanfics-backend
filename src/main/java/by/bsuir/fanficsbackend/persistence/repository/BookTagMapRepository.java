package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.BookTagMap;

import java.util.List;
import java.util.Optional;

public interface BookTagMapRepository extends CustomCrudRepository<BookTagMap> {
    List<BookTagMap> findByBookId(Long bookId);
    Optional<BookTagMap> findByBookIdAndTagId(Long bookId, Long tagId);
}
