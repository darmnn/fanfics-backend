package by.bsuir.fanficsbackend.service.dto;

import java.util.List;

public class BookResponseDTO extends ResponseDTO<BookResponseDTO> {
    private String name;

    private String description;

    private GenreResponseDTO genre;

    private FandomResponseDTO fandom;

    private CategoryResponseDTO category;

    private List<TagResponseDTO> tags;

    private UserResponseDTO user;

    private Integer quant_of_ratings;

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

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
