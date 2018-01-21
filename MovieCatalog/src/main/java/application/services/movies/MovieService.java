package application.services.movies;

import application.models.movies.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MovieService {

    public List<Movie> getAllMoviesFrom(String sourceId);

}
