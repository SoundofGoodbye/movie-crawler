package application.converters.custom;

import application.converters.Converter;
import application.entities.Movie;
import application.models.movies.MovieDTO;

public class MovieDTOtoMovieConverter implements Converter{

    public Movie convert(MovieDTO movieDTO){

        Movie movie = new Movie();
        movie.setTitle(movieDTO.getTitle());
        movie.setOriginalTitle(movieDTO.getOriginal_title());
        movie.setBackdropPath(movieDTO.getBackdrop_path());
        movie.setOverview(movieDTO.getOverview());
        movie.setAdult(movieDTO.isAdult());
        movie.setVideo(movieDTO.isVideo());
        movie.setGenreIds(movieDTO.getGenre_ids());
        movie.setOriginalLanguage(movieDTO.getOriginal_language());
        movie.setPopularity(movieDTO.getPopularity());
        movie.setPosterPath(movieDTO.getPoster_path());
        movie.setReleaseDate(movieDTO.getRelease_date());
        movie.setVoteAverage(movieDTO.getVote_average());
        movie.setVoteCount(movieDTO.getVote_count());

        return movie;
    }
}
