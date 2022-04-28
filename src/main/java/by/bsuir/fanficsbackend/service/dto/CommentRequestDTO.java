package by.bsuir.fanficsbackend.service.dto;

public class CommentRequestDTO extends RequestDTO {
    private String text;

    private Long bookId;

    private Long userId;

    /////////////////////////////////
    //
    // Getter & setter
    //
    ///////////////////////////////


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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
