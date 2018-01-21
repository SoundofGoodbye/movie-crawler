package application.controllers;

import application.models.User;
import application.models.movies.Movie;
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
    public ResponseEntity<List<Movie>> listMovies(@RequestParam("sourceId") String sourceId) {
        List<Movie> movies = moviesService.getAllMoviesFrom(sourceId);
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }
}
