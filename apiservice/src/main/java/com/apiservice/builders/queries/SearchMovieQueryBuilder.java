package com.apiservice.builders.queries;

import com.apiservice.constants.TMDBConstants;

//TODO: Might need to make it a bean if different query types support the same parameters.
public class SearchMovieQueryBuilder implements TMDBConstants {

    public String buildQuery(boolean includeAdults, String region, int year, int primaryReleaseDate) {
        StringBuilder resultBuilder = new StringBuilder();

        resultBuilder.append(INCLUDE_ADULT);
        resultBuilder.append(includeAdults);

        if (region != null) {
            resultBuilder.append(REGION);
            resultBuilder.append(region);
        }

        if (year != 0) {
            resultBuilder.append(YEAR);
            resultBuilder.append(year);
        }

        if (primaryReleaseDate != 0) {
            resultBuilder.append(PRIMARY_RELEASE_YEAR);
            resultBuilder.append(primaryReleaseDate);
        }

        return resultBuilder.toString();
    }
}
