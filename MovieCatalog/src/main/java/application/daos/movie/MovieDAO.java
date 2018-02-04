package application.daos.movie;

import application.entities.Movie;

import java.util.Collection;

public interface MovieDAO {
    void saveMovie(Movie movie);
    void saveAllMovies(Collection<Movie> movies);
}
