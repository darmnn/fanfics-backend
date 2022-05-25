package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@EnableJpaAuditing
@Table(name = "book")
public class Book extends AbstractEntity {
    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String photoPath;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "genre")
    private Genre genre;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "fandom")
    private Fandom fandom;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    @Column(columnDefinition = "integer default 0")
    private Integer likes;

    @Column(columnDefinition = "integer default 0")
    private Integer rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Fandom getFandom() {
        return fandom;
    }

    public void setFandom(Fandom fandom) {
        this.fandom = fandom;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) && description.equals(book.description) && photoPath.equals(book.photoPath) && genre.equals(book.genre) && fandom.equals(book.fandom) && category.equals(book.category) && user.equals(book.user) && likes.equals(book.likes) && rating.equals(book.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, photoPath, genre, fandom, category, user, likes, rating);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", genre=" + genre +
                ", fandom=" + fandom +
                ", category=" + category +
                ", user=" + user +
                ", likes=" + likes +
                ", rating=" + rating +
                '}';
    }

    @PrePersist
    public void prePersist() {
        this.setCreatedAt(OffsetDateTime.now());
        this.rating = 0;
        this.likes = 0;
    }
}
