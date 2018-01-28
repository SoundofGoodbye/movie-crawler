package com.apiservice.controllers;

import com.apiservice.services.movies.TMDBMovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("TMDBMovieController")
@RequestMapping("/movie")
public class TMDBMovieController {
    @Autowired
    private TMDBMovieSearchService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public String getMovie(@RequestParam(value = "q", required = true) final String query, @RequestParam(value = "lang", required = false) final String language,
                           @RequestParam(value = "page", required = false, defaultValue = "0") final int page, @RequestParam(value = "adults", required = false) final boolean includeAdults,
                           @RequestParam(value = "region", required = false) final String region, @RequestParam(value = "year", required = false, defaultValue = "0") final int year,
                           @RequestParam(value = "releaseDate", required = false, defaultValue = "0") final int primaryReleaseDate) {


        //TODO: When converter is created run result through it before returning.
        return movieService.getMovie(query, language, page, includeAdults, region, year, primaryReleaseDate);
    }
}
