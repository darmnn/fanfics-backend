package by.bsuir.fanficsbackend.service.dto;

public class AuthenticationDTO {
    private String username;

    private String password;

    ////////////////////////////////
    //
    // Getter & setter
    //
    ///////////////////////////////


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
