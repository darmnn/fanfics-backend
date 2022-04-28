package by.bsuir.fanficsbackend.service.dto;

public class ChapterUpdateRequestDTO extends RequestDTO {
    private String name;

    private String text;

    //////////////////////////////
    //
    // Getter & setter
    //
    /////////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
