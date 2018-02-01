package application.models.actors;

import application.entities.Movie;
import application.models.movies.MovieDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActorDTO {
    private Integer id;
    private String name;
    private Integer age;
    private LocalDate birthday;
    private String biography;
    private List<MovieDTO> movies;

    public ActorDTO() {
        this.movies = new ArrayList<>();
    }

    public ActorDTO(String name, Integer age, List<MovieDTO> movies, String bio) {
        this.name = name;
        this.age = age;
        this.movies = movies;
        this.biography = bio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setBirthday(String birthday) {
        LocalDate birthDayDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.birthday = birthDayDate;
    }

    public LocalDate getBirthday() {
        return birthday;
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

    public List<MovieDTO> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDTO> movies) {
        this.movies = movies;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String bio) {
        this.biography = bio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorDTO actorDTO = (ActorDTO) o;
        return Objects.equals(getName(), actorDTO.getName()) &&
                Objects.equals(getAge(), actorDTO.getAge()) &&
                Objects.equals(getBiography(), actorDTO.getBiography()) &&
                Objects.equals(getMovies(), actorDTO.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, getBiography(), movies);
    }

    @Override
    public String toString() {
        return "ActorDTO [name=" + getName() + ", age=" + getAge() + ", bio=" + getBiography() + ", movies[=" + Arrays.asList(movies)
                + "]" + "]";
    }
}
