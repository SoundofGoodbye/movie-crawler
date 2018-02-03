package application.controllers;

import application.converters.Converter;
import application.converters.apiservice.JsonToMovieConverter;
import application.converters.apiservice.JsonToMovieDetailsConverter;
import application.models.movies.MovieDTO;
import application.services.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                                                    @RequestParam(value = "appendToReponse", required = false) final String appendToResponse) {

        String movieData = moviesService.getMovie(movieId, language, appendToResponse);

        Converter<String, MovieDTO> converter = new JsonToMovieDetailsConverter();
        return new ResponseEntity<>(converter.convert(movieData), HttpStatus.OK);
    }

}
