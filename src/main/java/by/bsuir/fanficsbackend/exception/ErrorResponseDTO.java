package by.bsuir.fanficsbackend.exception;

public class ErrorResponseDTO {
    private String messageError;

    public ErrorResponseDTO(String messageError) {
        this.messageError = messageError;
    }

    ///////////////////////////////
    //
    // Getter & setter
    //
    ///////////////////////////////


    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }
}
