package by.bsuir.fanficsbackend.service.dto;

public class CommentResponseDTO extends ResponseDTO<CommentResponseDTO>{
    private String text;

    private UserResponseDTO user;

    ////////////////////////////
    //
    // Getter & setter
    /////////////////////////////


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }
}
