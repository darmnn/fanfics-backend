package by.bsuir.fanficsbackend.service.dto;

public class UserSearchDTO implements SearchDTO {
    private String name;

    private String password;

    ////////////////////////////
    //
    // Getter & setter
    //
    //////////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
