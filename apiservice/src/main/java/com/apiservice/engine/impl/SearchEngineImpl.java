package com.apiservice.engine.impl;

import com.apiservice.builders.queries.SearchEngineQueryBuilder;
import com.apiservice.engine.SearchEngine;
import com.apiservice.services.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;


public class SearchEngineImpl implements SearchEngine {

    @Autowired
    private TMDBService apiService;

    @Override
    public String searchActors(final String address, final String query, final String language, int page) {
        SearchEngineQueryBuilder queryBuilder = new SearchEngineQueryBuilder();

        return apiService.search(address, queryBuilder.buildQuery(query, language, page));
    }

    @Override
    public String searchMovie(final String address, final String query, final String language, int page) {
        SearchEngineQueryBuilder queryBuilder = new SearchEngineQueryBuilder();

        return apiService.search(address, queryBuilder.buildQuery(query, language, page));
    }
}
