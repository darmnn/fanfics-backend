package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.BookTagMap;

import java.util.List;

public interface BookTagMapRepository extends CustomCrudRepository<BookTagMap> {
    List<BookTagMap> findByBookId(Long bookId);
}
