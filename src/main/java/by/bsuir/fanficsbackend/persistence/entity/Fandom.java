package by.bsuir.fanficsbackend.persistence.entity;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@EnableJpaAuditing
public class Fandom extends AbstractEntity {
    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fandom fandom = (Fandom) o;
        return name.equals(fandom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Fandom{" +
                "name='" + name + '\'' +
                '}';
    }
}