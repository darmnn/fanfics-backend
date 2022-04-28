package by.bsuir.fanficsbackend.service.dto;

public class BookUpdateRequestDTO extends RequestDTO {
    private String description;

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
}
