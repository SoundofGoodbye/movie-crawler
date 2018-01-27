package com.apiservice.engine;

import java.util.List;

public interface SearchEngine {
    String searchActors(String searchOption, String query, String language, int page);
}
