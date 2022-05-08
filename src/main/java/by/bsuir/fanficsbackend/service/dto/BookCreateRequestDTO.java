package by.bsuir.fanficsbackend.service.dto;

import com.sun.istack.NotNull;

import java.util.List;

public class BookCreateRequestDTO extends RequestDTO {
    @NotNull
    private String name;

    private String description;

    private String photoPath;

    @NotNull
    private Long genreId;

    @NotNull
    private Long fandomId;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long userId;

    private List<Long> tagIds;

    ////////////////////////////////////////
    //
    // Getter & setter
    //
    //////////////////////////////////////


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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTags(List<Long> tags) {
        this.tagIds = tags;
    }
}
