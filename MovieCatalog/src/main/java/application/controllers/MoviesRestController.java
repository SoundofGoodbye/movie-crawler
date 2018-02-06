package application.controllers;

import application.converters.Converter;
import application.converters.apiservice.JsonToMovieConverter;
import application.converters.apiservice.JsonToMovieDetailsConverter;
import application.converters.custom.MovieToMovieDTOListConverter;
import application.entities.Movie;
import application.models.movies.MovieDTO;
import application.services.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
@RequestMapping(value = "/movies")
public class MoviesRestController {
    @Autowired
    private MovieService moviesService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> searchMovie(@RequestParam(value = "q", required = true) final String query, @RequestParam(value = "lang", required = false) final String language,
                                                @RequestParam(value = "page", required = false, defaultValue = "0") final int page, @RequestParam(value = "adults", required = false) final boolean includeAdults,
                                                @RequestParam(value = "region", required = false) final String region, @RequestParam(value = "year", required = false, defaultValue = "0") final int year,
                                                @RequestParam(value = "releaseDate", required = false, defaultValue = "0") final int primaryReleaseDate) {
        String movieData = moviesService.searchMovie(query, language, page, includeAdults, region, year, primaryReleaseDate);

        Converter<String, MovieDTO> converter = new JsonToMovieConverter();
        return new ResponseEntity<>(converter.convert(movieData), HttpStatus.OK);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public ResponseEntity<MovieDTO> getMovieDetails(@RequestParam(value = "movieId", required = true) final String movieId,
                                                    @RequestParam(value = "lang", required = false) final String language,
                                                    @RequestParam(value = "appendToResponse", required = false) final String appendToResponse) {

        String movieData = moviesService.getMovie(movieId, language, appendToResponse);

        Converter<String, MovieDTO> converter = new JsonToMovieDetailsConverter();
        return new ResponseEntity<>(converter.convert(movieData), HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getNewMovies() {
        //TODO: Calc new date
        List<Movie> newMovies = moviesService.getNew(LocalDate.parse("2017-07-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        Converter<List<Movie>, List<MovieDTO>> entityToDTOConverter = new MovieToMovieDTOListConverter();

        //TODO: Should work with list of T
        return new ResponseEntity<>(entityToDTOConverter.convert(newMovies), HttpStatus.OK);
    }

}
