package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
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
    private String email;

    @Column
    private String contactInfo;

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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && password.equals(user.password) && Objects.equals(age, user.age) && Objects.equals(about, user.about) && email.equals(user.email) && Objects.equals(contactInfo, user.contactInfo) && admin.equals(user.admin) && blocked.equals(user.blocked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, age, about, email, contactInfo, admin, blocked);
    }

    @PrePersist
    public void prePersist() {
        this.admin = false;
        this.blocked = false;
    }
}
