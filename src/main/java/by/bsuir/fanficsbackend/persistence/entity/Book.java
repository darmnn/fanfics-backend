package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@EnableJpaAuditing
public class Book extends AbstractEntity {
    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "genre")
    private Genre genre;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "fandom")
    private Fandom fandom;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_tag_map",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id")
    )
    private List<Tag> tags;

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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) && description.equals(book.description) && genre.equals(book.genre) && fandom.equals(book.fandom) && category.equals(book.category) && tags.equals(book.tags)  && quant_of_ratings.equals(book.quant_of_ratings) && rating.equals(book.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, genre, fandom, category, tags, quant_of_ratings, rating);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                ", fandom=" + fandom +
                ", category=" + category +
                ", tags=" + tags +
                ", quant_of_ratings=" + quant_of_ratings +
                ", rating=" + rating +
                '}';
    }
}
