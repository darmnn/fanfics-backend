package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Objects;

@Entity
@EnableJpaAuditing
@Table(name = "comment")
public class Comment extends AbstractEntity {
    @Column
    private String text;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "book")
    private Book book;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return text.equals(comment.text) && book.equals(comment.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, book);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", book=" + book +
                '}';
    }
}
