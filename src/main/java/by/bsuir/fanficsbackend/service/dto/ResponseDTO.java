package by.bsuir.fanficsbackend.service.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.OffsetDateTime;

public abstract class ResponseDTO<R extends RepresentationModel<? extends R>> extends RepresentationModel<R>{
    private Long id;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    /////////////////////////////////////////////
    //
    // Getters & setters
    //
    ////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
