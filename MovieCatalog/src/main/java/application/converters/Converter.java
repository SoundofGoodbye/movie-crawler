package application.converters;

import application.models.movies.MovieDTO;

public interface Converter<FROM, TO> {
    TO convert(FROM resultAsJson);
}
