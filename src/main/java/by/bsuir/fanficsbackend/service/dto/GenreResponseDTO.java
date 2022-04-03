package by.bsuir.fanficsbackend.service.dto;

public class GenreResponseDTO extends ResponseDTO<GenreResponseDTO> {
    private String name;

    /////////////////////////
    //
    // Getter & setter
    //
    //////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
