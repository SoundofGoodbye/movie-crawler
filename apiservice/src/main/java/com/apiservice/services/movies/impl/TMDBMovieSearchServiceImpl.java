package com.apiservice.services.movies.impl;

import com.apiservice.builders.queries.SearchMovieQueryBuilder;
import com.apiservice.engine.GetEngine;
import com.apiservice.engine.SearchEngine;
import com.apiservice.services.movies.TMDBMovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;

public class TMDBMovieSearchServiceImpl implements TMDBMovieSearchService {
    private static final String ADDRESS = "search";
    private static final String SEARCH_OPTION = "movie";
    private SearchMovieQueryBuilder queryBuilder;

    @Autowired()
    private SearchEngine searchEngine;
    @Autowired
    private GetEngine getEngine;

    @Override
    public String getMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate) {
        queryBuilder = new SearchMovieQueryBuilder();
        String tmdbMovieSearchQuery = queryBuilder.buildParamsQuery(query, includeAdults, region, year, primaryReleaseDate);

        return searchEngine.searchMovie(ADDRESS + "/" + SEARCH_OPTION,
                query + tmdbMovieSearchQuery, language, page);
    }

    @Override
    public String getMovieDetails(final String movieId,final  String language,final  String appendToResponse) {
        String address = SEARCH_OPTION + "/" + movieId;
        return getEngine.getMovieDetails(address, language, appendToResponse);
    }
}
