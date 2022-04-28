package by.bsuir.fanficsbackend.service.dto;

public class ChapterCreateRequestDTO extends RequestDTO {
    private Integer number;

    private String name;

    private String text;

    private Long bookId;

    ///////////////////////////////
    //
    // Getter & setter
    //
    ///////////////////////////////


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

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
