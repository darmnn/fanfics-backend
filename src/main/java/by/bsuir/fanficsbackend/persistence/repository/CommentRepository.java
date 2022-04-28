package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.Comment;

import java.util.List;

public interface CommentRepository extends CustomCrudRepository<Comment> {
    List<Comment> findByBookId(Long bookId);
}
