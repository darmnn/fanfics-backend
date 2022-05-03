package by.bsuir.fanficsbackend.service.dto;

import java.util.Objects;

public class TagResponseDTO extends ResponseDTO<TagResponseDTO> {
    private String name;

    /////////////////////////////////
    //
    // Getter & setter
    //
    /////////////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TagResponseDTO that = (TagResponseDTO) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
