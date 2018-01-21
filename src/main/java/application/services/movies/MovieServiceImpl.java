package application.services.movies;

import application.models.movies.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Override
    public List<Movie> getAllMoviesFrom(String sourceId) {
        List<Movie> movies = new ArrayList<>();
        List<String> actorNames = new ArrayList<>();
        actorNames.add("Johnny Depp");
        Movie movie = new Movie("Pirates of the Caribean", "2010", actorNames);
        movies.add(movie);

        return movies;
    }
}
