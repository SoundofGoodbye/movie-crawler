package com.apiservice.services.movies.impl;

import com.apiservice.builders.queries.SearchMovieQueryBuilder;
import com.apiservice.constants.TMDBConstants;
import com.apiservice.services.TMDBService;
import com.apiservice.services.movies.TMDBMovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class TMDBMovieSearchServiceImpl implements TMDBMovieSearchService {
    private static final String QUERY_URL = "search/movie";
    private SearchMovieQueryBuilder queryBuilder;

    @Autowired()
    private TMDBService apiService;

    @Override
    public String getMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate) {
        queryBuilder = new SearchMovieQueryBuilder();
        String tmdbMovieSearchQuery = queryBuilder.buildQuery(query, language, page, includeAdults, region, year, primaryReleaseDate);

        return apiService.query(getSearchType(), tmdbMovieSearchQuery);
    }

    public String getSearchType() {
        return QUERY_URL;
    }
}
