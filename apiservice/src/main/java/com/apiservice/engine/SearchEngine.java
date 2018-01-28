package com.apiservice.engine;

public interface SearchEngine {
    String searchActors(String searchOption, String query, String language, int page);

    String searchMovie(final String searchOption, final String query, final String language, int page);
}
