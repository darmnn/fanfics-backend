package by.bsuir.fanficsbackend.service.dto;

public class ChapterSearchDTO implements SearchDTO{
    private Long bookId;

    private String bookName;

    //////////////////////////
    //
    // Getter & setter
    //
    //////////////////////


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
