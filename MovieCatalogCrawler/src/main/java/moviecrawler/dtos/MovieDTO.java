package moviecrawler.dtos;

import java.util.ArrayList;
import java.util.List;

public class MovieDTO {

    private String title;
    private String releaseDate;
    private List<String> actors;

    public MovieDTO() {
    }

    public MovieDTO(String title, String releaseDate, List<String> actors) {
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
}
