package application.converters.custom;

import application.converters.Converter;
import application.entities.Movie;
import application.models.movies.MovieDTO;

import java.time.format.DateTimeFormatter;

public class MovieToMovieDTOConverter implements Converter<Movie, MovieDTO> {
    @Override
    public MovieDTO convert(Movie entity) {
        MovieDTO movie = new MovieDTO();
        movie.setId(entity.getId());
        movie.setTitle(entity.getTitle());
        movie.setPoster_path(entity.getPosterPath());
        movie.setOverview(entity.getOverview());
        movie.setRelease_date((entity.getReleaseDate()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        movie.setVote_count(entity.getVoteCount());

        return movie;
    }
}
