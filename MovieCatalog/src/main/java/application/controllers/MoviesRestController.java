package application.controllers;

import application.models.movies.MovieDTO;
import application.services.movies.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MoviesRestController {

    @Autowired
    private MovieService moviesService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> listMovies(@RequestParam("sourceId") String sourceId) {
        List<MovieDTO> movies = moviesService.getAllMoviesFrom(sourceId);
        return new ResponseEntity<List<MovieDTO>>(movies, HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<String> searchMovie(@RequestParam(value = "q", required = true) final String query, @RequestParam(value = "lang", required = false) final String language,
                                              @RequestParam(value = "page", required = false, defaultValue = "0") final int page, @RequestParam(value = "adults", required = false) final boolean includeAdults,
                                              @RequestParam(value = "region", required = false) final String region, @RequestParam(value = "year", required = false, defaultValue = "0") final int year,
                                              @RequestParam(value = "releaseDate", required = false, defaultValue = "0") final int primaryReleaseDate) {
        String movieData = moviesService.searchMovie(query, language, page, includeAdults, region, year, primaryReleaseDate);

        return new ResponseEntity<String>(movieData, HttpStatus.OK);
    }
}
