package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CustomCrudRepository<Book>{
    @Query("SELECT btm.book FROM BookTagMap btm " +
            "WHERE btm.tag.id = :tagId")
    List<Book> findByTag(@Param("tagId") Long tagId);
}
