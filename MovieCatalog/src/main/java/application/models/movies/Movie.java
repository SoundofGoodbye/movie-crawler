package application.models.movies;

import application.models.User;

import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String year;
    private List<String> actorNames;

    public Movie(String title, String year, List<String> actorNames) {
        this.title = title;
        this.year = year;
        this.actorNames = actorNames;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getActorNames() {
        return actorNames;
    }

    public void setActorNames(List<String> actorNames) {
        this.actorNames = actorNames;
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
        return "Movie [title=" + getTitle() + ", year=" + getYear() + ", actors[=" + Arrays.asList(actorNames)
                + "]" +"]";
    }
}
