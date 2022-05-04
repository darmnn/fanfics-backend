package by.bsuir.fanficsbackend.service.dto;

import org.springframework.hateoas.RepresentationModel;

import java.time.OffsetDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ResponseDTO<?> that = (ResponseDTO<?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
