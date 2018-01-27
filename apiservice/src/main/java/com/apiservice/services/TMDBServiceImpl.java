package com.apiservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TMDBServiceImpl implements TMDBService {
    @Value("${tmdb.api.key}")
    private String apiKey;
    private String url = "https://api.themoviedb.org/3/";
    private static final String SEARCH_QUERY = "search/";

    private String query(final String searchType, final String searchOption, final String params) {
        RestTemplate restTemplate = new RestTemplate();

        String query = getUrl() + searchType + searchOption +"?api_key=" + apiKey + params;

        ResponseEntity<String> rateResponse =
                restTemplate.exchange(query, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                });
        return rateResponse.getBody();
    }

    @Override
    public String search(final String searchOption, final String query) {
        return query(SEARCH_QUERY, searchOption, query);
    }

    @Override
    public String discover() {
        return null;
    }

    @Override
    public String find() {
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
