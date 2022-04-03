package by.bsuir.fanficsbackend.service.dto;

public class FandomResponseDTO extends ResponseDTO<FandomResponseDTO> {
    private String name;

    /////////////////////////////////////
    //
    // Getter & setter
    //
    ///////////////////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
