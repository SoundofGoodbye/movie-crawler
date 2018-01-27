package com.apiservice.engine.impl;

import com.apiservice.builders.queries.SearchEngineQueryBuilder;
import com.apiservice.engine.SearchEngine;
import com.apiservice.services.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;


public class SearchEngineImpl implements SearchEngine {

    @Autowired
    private TMDBService apiService;

    @Override
    public String searchActors(final String searchOption, final String query, final String language, int page) {
        SearchEngineQueryBuilder queryBuilder = new SearchEngineQueryBuilder();

        return apiService.search(searchOption, queryBuilder.buildQuery(query, language, page));
    }

    public String searchMovie(final String searchOption, final String query, final String language, int page) {
        SearchEngineQueryBuilder queryBuilder = new SearchEngineQueryBuilder();

        return apiService.search(searchOption, queryBuilder.buildQuery(query, language, page));
    }
}
