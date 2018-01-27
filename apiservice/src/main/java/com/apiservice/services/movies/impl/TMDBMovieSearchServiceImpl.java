package com.apiservice.services.movies.impl;

import com.apiservice.builders.queries.SearchMovieQueryBuilder;
import com.apiservice.engine.SearchEngine;
import com.apiservice.services.movies.TMDBMovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;

public class TMDBMovieSearchServiceImpl implements TMDBMovieSearchService {
    private static final String SEARCH_OPTION = "movie";
    private SearchMovieQueryBuilder queryBuilder;

    @Autowired()
    private SearchEngine searchEngine;

    @Override
    public String getMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate) {
        queryBuilder = new SearchMovieQueryBuilder();
        String tmdbMovieSearchQuery = queryBuilder.buildQuery(includeAdults, region, year, primaryReleaseDate);

        return searchEngine.searchActors(SEARCH_OPTION, query + tmdbMovieSearchQuery, language, page);
    }
}
