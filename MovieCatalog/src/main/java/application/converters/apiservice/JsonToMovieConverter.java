package application.converters.apiservice;

import application.converters.Converter;
import application.models.movies.MovieDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToMovieConverter implements Converter<String, MovieDTO> {

    public MovieDTO convert(String movieJson) {
        ObjectMapper mapper = new ObjectMapper();
        MovieDTO movie = null;

        try {
            JsonNode rawMoviesData = mapper.readValue(movieJson, JsonNode.class);
            JsonNode movieJsonNode = rawMoviesData.get("results").get(0);
            String movieJsonString = movieJsonNode.toString();
            movie = mapper.readValue(movieJsonString, MovieDTO.class);
        } catch (IOException e) {
            //TODO: Add log here
            e.printStackTrace();
        }

        return movie;
    }
}
