package com.apiservice;

import com.apiservice.engine.SearchEngine;
import com.apiservice.engine.impl.SearchEngineImpl;
import com.apiservice.services.TMDBService;
import com.apiservice.services.TMDBServiceImpl;
import com.apiservice.services.actors.TMDBActorsSearchService;
import com.apiservice.services.actors.impl.TMDBActorsSearchServiceImpl;
import com.apiservice.services.movies.TMDBMovieSearchService;
import com.apiservice.services.movies.impl.TMDBMovieSearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan
/**
 * Configuration file to be used by exposed APIs.
 * Only bean that will be used by other APIS should be written here.
 */
public class BeanConfiguration {
    @Bean(name = "TMDBSearchMovieService")
    public TMDBMovieSearchService movieSearchService() {
        TMDBMovieSearchService service = new TMDBMovieSearchServiceImpl();

        return service;
    }

    @Bean(name = "TMDBActorsSearchService")
    public TMDBActorsSearchService actorsSearchService() {
        TMDBActorsSearchService actorsSearchService = new TMDBActorsSearchServiceImpl();

        return actorsSearchService;
    }
}
