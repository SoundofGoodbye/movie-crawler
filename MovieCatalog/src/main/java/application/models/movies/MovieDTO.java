package application.models.movies;

import application.models.actors.ActorDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MovieDTO {
    private String title;
    //TODO use actual date instead of string
    private String releaseDate;
    private List<ActorDTO> actors;
    private Genre genre;
    private Integer durationInMin;
    private Boolean isMovie;

    public MovieDTO() {
        this.actors = new ArrayList<>();
    }

    public MovieDTO(String title, String releaseDate, List<ActorDTO> actors, Genre genre, Integer durationInMin, Boolean isMovie) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.actors = actors;
        this.genre = genre;
        this.durationInMin = durationInMin;
        this.isMovie = isMovie;
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

    public List<ActorDTO> getActors() {
        return actors;
    }

    public void setActors(List<ActorDTO> actors) {
        this.actors = actors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(Integer durationInMin) {
        this.durationInMin = durationInMin;
    }

    public Boolean getIsMovie() {
        return isMovie;
    }

    public void setIsMovie(Boolean movie) {
        isMovie = movie;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(getTitle(), movieDTO.getTitle()) &&
                Objects.equals(getReleaseDate(), movieDTO.getReleaseDate()) &&
                Objects.equals(getActors(), movieDTO.getActors()) &&
                getGenre() == movieDTO.getGenre() &&
                Objects.equals(getDurationInMin(), movieDTO.getDurationInMin()) &&
                Objects.equals(getIsMovie(), movieDTO.getIsMovie());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getReleaseDate(), getActors(), getGenre(), getDurationInMin(), getIsMovie());
    }

    @Override
    public String toString() {
        return "MovieDTO [title=" + getTitle() + ", genre= " + getGenre() + ", releaseDate=" + getReleaseDate() + ", actors[=" + Arrays.asList(actors) + ", duration=" + ("" + getDurationInMin() / 60 + "hr " + getDurationInMin() % 60 + "min")
                + "]" + "]";
    }
}
