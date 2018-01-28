package application.models.actors;

import application.entities.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorDTO {
    private String name;
    private Integer age;
    private String bio;
    private List<Movie> movies;

    public ActorDTO() {
        this.movies = new ArrayList<>();
    }

    public ActorDTO(String name, Integer age, List<Movie> movies, String bio) {
        this.name = name;
        this.age = age;
        this.movies = movies;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDTO actorDTO = (ActorDTO) o;
        return Objects.equals(getName(), actorDTO.getName()) &&
                Objects.equals(getAge(), actorDTO.getAge()) &&
                Objects.equals(getBio(), actorDTO.getBio()) &&
                Objects.equals(getMovies(), actorDTO.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, bio, movies);
    }

    @Override
    public String toString() {
        return "ActorDTO [name=" + getName() + ", age=" + getAge() + ", bio=" + getBio() + ", movies[=" + Arrays.asList(movies)
                + "]" + "]";
    }
}
