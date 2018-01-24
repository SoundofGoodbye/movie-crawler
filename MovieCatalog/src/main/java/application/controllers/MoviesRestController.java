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

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        String movies = moviesService.test();
        return new ResponseEntity<String>(movies, HttpStatus.OK);
    }
}
