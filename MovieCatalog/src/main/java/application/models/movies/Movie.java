package application.models.movies;

import application.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie {
    private String title;
    private String releaseDate;
    private List<String> actors;

    public Movie() {

    }

    public Movie(String title, String releaseDate, List<String> actors) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.actors = actors;
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

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
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
        return "Movie [title=" + getTitle() + ", releaseDate=" + getReleaseDate() + ", actors[=" + Arrays.asList(actors)
                + "]" + "]";
    }
}
