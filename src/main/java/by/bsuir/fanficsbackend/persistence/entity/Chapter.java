package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Objects;

@Entity
@EnableJpaAuditing
@Table(name = "chapter")
public class Chapter extends AbstractEntity{
    @Column
    private Integer number;

    @Column
    private String name;

    @Column
    private String text;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "book")
    private Book book;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        Chapter chapter = (Chapter) o;
        return number.equals(chapter.number) && name.equals(chapter.name) && text.equals(chapter.text) && book.equals(chapter.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, text, book);
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", book=" + book +
                '}';
    }
}
