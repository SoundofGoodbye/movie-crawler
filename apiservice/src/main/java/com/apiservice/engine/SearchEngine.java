package com.apiservice.engine;

public interface SearchEngine {
    String searchActors(final String address, final String query, final String language, int page);

    String searchMovie(final String address, final String query, final String language, int page);
}
