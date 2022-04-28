package by.bsuir.fanficsbackend.service.dto;

public class UserRequestDTO extends RequestDTO{
    private String name;

    private String password;

    private Integer age;

    private String about;

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
}
