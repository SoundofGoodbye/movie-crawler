package application.entities;

import application.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
//@Table(name = "movie")
public class Movie {

    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String releaseDate;

    //TODO: Refactor to use Actor model
   // @OneToOne
    //@JoinColumn(name = "uniqueId")
  /*  @Ignore
    private List<String> actors;*/

    public Movie() {

    }

    //TODO: Remove after creating actors model
    public Movie(String title, String releaseDate) {
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Movie(String title, String releaseDate, List<String> actors) {
        this.title = title;
        this.releaseDate = releaseDate;
        //this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Movie))
            return false;
        Movie other = (Movie) obj;
        if (title != other.title)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "MovieDTO [title=" + getTitle() + ", releaseDate=" + getReleaseDate() + ", actors[="
                + "]" + "]";
    }
}
