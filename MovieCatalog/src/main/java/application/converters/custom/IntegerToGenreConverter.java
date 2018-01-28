package application.converters.custom;

import application.converters.Converter;
import application.entities.Genre;

import java.util.ArrayList;
import java.util.List;

public class IntegerToGenreConverter implements Converter<List<Integer>, List<Genre>> {

    @Override
    public List<Genre> convert(List<Integer> resultAsJson) {
        List<Genre> genres = new ArrayList<>();

        for (Integer currentId : resultAsJson) {
            genres.add(new Genre(currentId));
        }

        return genres;
    }
}
