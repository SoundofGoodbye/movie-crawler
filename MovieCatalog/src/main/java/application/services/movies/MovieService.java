package application.services.movies;

public interface MovieService {

    String searchMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate);

    String getMovie(final String movieId, final String language, final String appendToResponse);
}
