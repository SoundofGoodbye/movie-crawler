package com.apiservice.builders.queries;

import com.apiservice.constants.TMDBConstants;

public class SearchEngineQueryBuilder implements TMDBConstants {
    public String buildQuery(String query, String language, int page) {
        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append(QUERY_PARAM);
        resultBuilder.append(query);

        if (language != null) {
            resultBuilder.append(LANGUAGE);
            resultBuilder.append(language);
        }

        if (page != 0) {
            resultBuilder.append(PAGE);
            resultBuilder.append(page);
        }

        return resultBuilder.toString();
    }
}
