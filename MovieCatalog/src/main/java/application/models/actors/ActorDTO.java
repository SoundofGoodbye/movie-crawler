package application.models.actors;

import application.entities.Movie;
import application.models.movies.MovieDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof MovieDTO))
            return false;
        ActorDTO other = (ActorDTO) obj;
        if (this.name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ActorDTO [name=" + getName() + ", age=" + getAge() + ", bio=" + getBio() + ", movies[=" + Arrays.asList(movies)
                + "]" + "]";
    }
}
