package by.bsuir.fanficsbackend.service.dto;

import com.sun.istack.NotNull;

public class UserRequestDTO extends RequestDTO{
    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String email;

    private Integer age;

    private String about;

    private String contactInfo;

    ///////////////////////////////////
    //
    // Getter & setter
    //
    ///////////////////////////////////


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
