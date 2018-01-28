package com.apiservice.services.actors.impl;

import com.apiservice.engine.SearchEngine;
import com.apiservice.services.actors.TMDBActorsSearchService;
import org.springframework.beans.factory.annotation.Autowired;

public class TMDBActorsSearchServiceImpl implements TMDBActorsSearchService {
    private static String SEARCH_OPTION = "person";

    @Autowired
    private SearchEngine searchEngine;

    @Override
    public String getActor(final String query, final String language, int page, boolean includeAdult, final String region) {
        //TODO: Add Actor specific params
        // build query + specific params incAdult and region
        return searchEngine.searchActors(SEARCH_OPTION, query, language, page);
    }
}
