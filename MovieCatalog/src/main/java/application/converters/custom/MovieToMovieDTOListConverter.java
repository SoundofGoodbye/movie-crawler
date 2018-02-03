package application.converters.custom;

import application.converters.Converter;
import application.entities.Movie;
import application.models.movies.MovieDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MovieToMovieDTOListConverter implements Converter<List<Movie>, List<MovieDTO>> {

    private Converter<Movie, MovieDTO> converter;

    @Override
    public List<MovieDTO> convert(List<Movie> resultAsJson) {
        converter = new MovieToMovieDTOConverter();
        return resultAsJson.stream().map(entity -> converter.convert(entity)).collect(Collectors.toList());
    }
}
