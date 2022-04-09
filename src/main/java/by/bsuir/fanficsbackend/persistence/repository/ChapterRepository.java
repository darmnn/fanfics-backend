package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.Chapter;

import java.util.List;

public interface ChapterRepository extends CustomCrudRepository<Chapter> {
    List<Chapter> findByBookId(Long bookId);
}
