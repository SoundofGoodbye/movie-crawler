package application.services.movies;

import application.models.movies.MovieDTO;

import java.util.List;

public interface MovieService {

    public String searchMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate);
}
