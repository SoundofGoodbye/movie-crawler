package application.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {

    public Genre(Integer id) {
        this.id = id;
    }

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
