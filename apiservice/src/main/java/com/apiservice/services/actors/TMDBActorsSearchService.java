package com.apiservice.services.actors;

public interface TMDBActorsSearchService {
    String getActor(String query, String language, int page, boolean includeAdult, String region);
}
