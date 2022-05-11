package by.bsuir.fanficsbackend.service.dto;

import java.util.List;

public class BookUpdateRequestDTO extends RequestDTO {
    private String description;

    private Long genreId;

    private Long fandomId;

    private Long categoryId;

    private List<String> tags;

    ////////////////////////////
    //
    // Getter & setter
    //
    ///////////////////////////


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getFandomId() {
        return fandomId;
    }

    public void setFandomId(Long fandomId) {
        this.fandomId = fandomId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
