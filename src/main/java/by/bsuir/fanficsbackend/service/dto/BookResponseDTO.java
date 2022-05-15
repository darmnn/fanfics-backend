package by.bsuir.fanficsbackend.service.dto;

import java.util.List;
import java.util.Objects;

public class BookResponseDTO extends ResponseDTO<BookResponseDTO> {
    private String name;

    private String description;

    private GenreResponseDTO genre;

    private FandomResponseDTO fandom;

    private CategoryResponseDTO category;

    private List<TagResponseDTO> tags;

    private UserResponseDTO user;

    private Integer likes;

    private Integer rating;

    /////////////////////////////////////////////
    //
    // Getters & setters
    //
    ////////////////////////////////////////////


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

    public GenreResponseDTO getGenre() {
        return genre;
    }

    public void setGenre(GenreResponseDTO genre) {
        this.genre = genre;
    }

    public FandomResponseDTO getFandom() {
        return fandom;
    }

    public void setFandom(FandomResponseDTO fandom) {
        this.fandom = fandom;
    }

    public CategoryResponseDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDTO category) {
        this.category = category;
    }

    public List<TagResponseDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagResponseDTO> tags) {
        this.tags = tags;
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

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookResponseDTO that = (BookResponseDTO) o;
        return name.equals(that.name) && description.equals(that.description) && Objects.equals(likes, that.likes) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, likes, rating);
    }
}
