package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
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
    private Integer quant_of_ratings;

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

    public Integer getQuant_of_ratings() {
        return quant_of_ratings;
    }

    public void setQuant_of_ratings(Integer quant_of_ratings) {
        this.quant_of_ratings = quant_of_ratings;
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
        return name.equals(book.name) && description.equals(book.description) && photoPath.equals(book.photoPath) && genre.equals(book.genre) && fandom.equals(book.fandom) && category.equals(book.category) && user.equals(book.user) && quant_of_ratings.equals(book.quant_of_ratings) && rating.equals(book.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, photoPath, genre, fandom, category, user, quant_of_ratings, rating);
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
                ", quant_of_ratings=" + quant_of_ratings +
                ", rating=" + rating +
                '}';
    }
}
