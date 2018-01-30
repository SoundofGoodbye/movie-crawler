package com.apiservice.services.actors;

public interface TMDBActorsSearchService {
    String getActor(final String query, final String language, int page, boolean includeAdult, final String region);

    String getActorDetails(final String personId, final String language, final String appendToResponse);
}
