package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Objects;

@Entity
@EnableJpaAuditing
@Table(name = "book_tag_map")
public class BookTagMap extends AbstractEntity {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book")
    private Book book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag")
    private Tag tag;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookTagMap that = (BookTagMap) o;
        return book.equals(that.book) && tag.equals(that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, tag);
    }

    @Override
    public String toString() {
        return "BookTagMap{" +
                "book=" + book +
                ", tag=" + tag +
                '}';
    }
}
