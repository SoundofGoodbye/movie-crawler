package application.services.movies;

import application.entities.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    String searchMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate);

    String getMovie(final String movieId, final String language, final String appendToResponse);

    List<Movie> getNew(LocalDate afterDate);
}
