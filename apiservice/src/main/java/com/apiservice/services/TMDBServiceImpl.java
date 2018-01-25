package com.apiservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("TMDBService")
public class TMDBServiceImpl implements TMDBService {
    @Value("${tmdb.api.key}")
    private String apiKey;

    private String url = "https://api.themoviedb.org/3/movie/76341?api_key=";

    public String getAllMoviesFrom() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> rateResponse =
                restTemplate.exchange(url + apiKey,
                        HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                        });
        return rateResponse.getBody();
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
