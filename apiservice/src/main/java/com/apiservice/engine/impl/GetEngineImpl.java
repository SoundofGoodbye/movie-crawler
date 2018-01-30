package com.apiservice.engine.impl;

import com.apiservice.engine.GetEngine;
import com.apiservice.services.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;

public class GetEngineImpl implements GetEngine {
    @Autowired
    private TMDBService apiService;

    @Override
    public String getActors(final String address, final String language, final String appendToResponse) {

        String params = "&language=" + language + "&append_to_response=" + appendToResponse;
        return apiService.get(address, params);
    }
}
