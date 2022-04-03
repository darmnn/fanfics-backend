package by.bsuir.fanficsbackend.service.dto;

public class ChapterResponseDTO extends ResponseDTO<ChapterResponseDTO> {
    private Integer number;

    private String name;

    private String text;

    private BookResponseDTO book;

    /////////////////////////////////
    //
    // Getter & setter
    //
    ////////////////////////////////


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

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

    public BookResponseDTO getBook() {
        return book;
    }

    public void setBook(BookResponseDTO book) {
        this.book = book;
    }
}
