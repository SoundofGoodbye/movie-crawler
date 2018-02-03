package application.converters.custom;

import application.converters.Converter;
import application.entities.Movie;
import application.models.movies.MovieDTO;

public class MovieDTOtoMovieEntityConverter implements Converter<MovieDTO, Movie> {
    @Override
    public Movie convert(MovieDTO movieDTO) {
        Movie movieEntity = new Movie();
        IntegerToGenreConverter integerToGenreConverter = new IntegerToGenreConverter();
        movieEntity.setTitle(movieDTO.getTitle());
//        movieEntity.setReleaseDate(movieDTO.getRelease_date());
//        movieEntity.setVoteCount(movieDTO.getVote_count());
//        movieEntity.setVideo(movieDTO.isVideo());
//        movieEntity.setVoteAverage(movieDTO.getVote_average());
//        movieEntity.setPopularity(movieDTO.getPopularity());
//        movieEntity.setPosterPath(movieDTO.getPoster_path());
//        movieEntity.setOriginalLanguage(movieDTO.getOriginal_language());
//        movieEntity.setOriginalTitle(movieDTO.getOriginal_title());
//        movieEntity.setGenreIds(integerToGenreConverter.convert(movieDTO.getGenre_ids()));
//        movieEntity.setBackdropPath(movieDTO.getBackdrop_path());
//        movieEntity.setAdult(movieDTO.isAdult());
//        movieEntity.setOverview(movieDTO.getOverview());

        return movieEntity;
    }
}
