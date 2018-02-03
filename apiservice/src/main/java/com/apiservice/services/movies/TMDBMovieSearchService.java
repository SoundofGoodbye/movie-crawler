package com.apiservice.services.movies;

/**
 * Interface that defines the methods for searching for movies through TMDB API.
 */
public interface TMDBMovieSearchService {

    /**
     * Builds the query that will be used to get results from TMDB.
     *
     * @param query              - the actual search string, e.g. the movie title
     * @param language
     * @param page
     * @param includeAdults
     * @param region
     * @param year
     * @param primaryReleaseDate
     * @return
     */
    String getMovie(final String query, final String language, int page, boolean includeAdults, final String region, int year, int primaryReleaseDate);

    String getMovieDetails(final String movieId, final String language, final String appendToResponse);
}
