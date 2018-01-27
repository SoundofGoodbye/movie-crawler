package com.apiservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.apiservice.services.TMDBService;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class MoviesController {

    private TMDBService tmdbService;

    @RequestMapping(value = "movies/list", method = RequestMethod.GET)
    public ResponseEntity<String> listMovies() {
        String movies = tmdbService.search();
        return new ResponseEntity<String>(movies, HttpStatus.OK);
    }
}
