package com.apiservice.engine;

public interface GetEngine {

    String getActorDetails(final String address, final String language, final String appendToResponse);

    String getMovieDetails(final String address, final String language, final String appendToResponse);
}
