package application.services.movies;

import application.models.movies.MovieDTO;

import java.util.List;

public interface MovieService {

    public List<MovieDTO> getAllMoviesFrom(String sourceId);

}
