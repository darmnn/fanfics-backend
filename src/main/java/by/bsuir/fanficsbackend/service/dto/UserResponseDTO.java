package by.bsuir.fanficsbackend.service.dto;

public class UserResponseDTO extends ResponseDTO<UserResponseDTO> {
    private String name;

    private Integer age;

    private String about;

    private Boolean admin;

    private Boolean blocked;

    ////////////////////////////
    //
    // Getters & setters
    //
    /////////////////////////////


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
}
