package by.bsuir.fanficsbackend.service.dto;

public class CategoryResponseDTO extends ResponseDTO<CategoryResponseDTO> {
    private String name;

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
}
