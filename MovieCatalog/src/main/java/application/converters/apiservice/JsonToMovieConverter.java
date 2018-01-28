package application.converters.apiservice;

import application.converters.Converter;
import application.models.movies.MovieDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToMovieConverter implements Converter {

    public MovieDTO convertApiServiceResultToMovieDTO(String movieJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        JsonNode rawMoviesData = mapper.readValue(movieJson, JsonNode.class);
        JsonNode movieJsonNode = rawMoviesData.get("results").get(1);
        String movieJsonString = movieJsonNode.toString();
        MovieDTO movie = mapper.readValue(movieJsonString, MovieDTO.class);

        return movie;
    }

}
