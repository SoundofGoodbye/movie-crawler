package application.services.movies;

public interface MovieService {

    public String searchMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate);
}
