package by.bsuir.fanficsbackend.service.dto;

public class ChapterSearchDTO implements SearchDTO{
    private String bookName;

    //////////////////////////
    //
    // Getter & setter
    //
    //////////////////////


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
