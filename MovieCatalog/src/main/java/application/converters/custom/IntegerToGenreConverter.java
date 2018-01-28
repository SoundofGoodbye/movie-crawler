package application.converters.custom;

import application.converters.Converter;
import application.entities.Genre;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerToGenreConverter implements Converter<List<Integer>, List<Genre>> {

    @Override
    public List<Genre> convert(List<Integer> resultAsJson) {
        return resultAsJson.stream().
                map(currentId -> new Genre(currentId)).
                collect(Collectors.toList());
    }
}
