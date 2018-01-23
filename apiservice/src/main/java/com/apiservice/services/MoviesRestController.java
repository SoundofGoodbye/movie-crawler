package com.apiservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.apiservice.services.TMDBService;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class MoviesRestController {

    @Autowired
    private TMDBService tmdbService;

    @RequestMapping(value = "test/", method = RequestMethod.GET)
    public ResponseEntity<String> listMovies() {
        String movies = tmdbService.getAllMoviesFrom();
        return new ResponseEntity<String>(movies, HttpStatus.OK);
    }
}
