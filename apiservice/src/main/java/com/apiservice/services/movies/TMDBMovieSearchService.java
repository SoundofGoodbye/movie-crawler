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
    public String getMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate);
}
