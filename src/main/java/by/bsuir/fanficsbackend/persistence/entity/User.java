package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@EnableJpaAuditing
public class User extends AbstractEntity {
    @Column
    private String name;

    @Column
    private String password;

    @Column
    private Integer age;

    @Column
    private String about;

    @Column
    private Boolean admin;

    @Column
    private Boolean blocked;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && password.equals(user.password) && age.equals(user.age) && about.equals(user.about) && admin.equals(user.admin) && blocked.equals(user.blocked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, age, about, admin, blocked);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", about='" + about + '\'' +
                ", admin=" + admin +
                ", blocked=" + blocked +
                '}';
    }
}
