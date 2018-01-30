package application.converters.apiservice;

import application.converters.Converter;
import application.models.movies.MovieDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonToMovieDetailsConverter implements Converter<String, MovieDTO> {


    public MovieDTO convert(String movieJson) {
        ObjectMapper mapper = new ObjectMapper();
        MovieDTO movie = null;

        try {
            JsonNode rawMoviesData = mapper.readValue(movieJson, JsonNode.class);
            movie = mapper.readValue(rawMoviesData.toString(), MovieDTO.class);
        } catch (IOException e) {
            //TODO: Add log here
            e.printStackTrace();
        }

        return movie;
    }
}
