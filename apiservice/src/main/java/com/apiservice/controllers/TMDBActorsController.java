package com.apiservice.controllers;

import com.apiservice.engine.SearchEngine;
import com.apiservice.services.actors.TMDBActorsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("TMDBActorsController")
@RequestMapping("/actor")
public class TMDBActorsController {
    @Autowired
    private TMDBActorsSearchService actorsSearchService;

    @RequestMapping(method = RequestMethod.GET)
    public String getActor(@RequestParam(value = "q", required = true) final String query,
                           @RequestParam(value = "lang", required = false) final String language,
                           @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                           @RequestParam(value = "include_adult", required = false) boolean includeAdult,
                           @RequestParam(value = "region", required = false) final String region) {
        return actorsSearchService.getActor(query, language, page, includeAdult, region);
    }
}
