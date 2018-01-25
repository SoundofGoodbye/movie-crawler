package com.apiservice;

import com.apiservice.services.TMDBService;
import com.apiservice.services.TMDBServiceImpl;
import com.apiservice.services.movies.TMDBMovieSearchService;
import com.apiservice.services.movies.impl.TMDBMovieSearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan
public class BeanConfiguration {

    @Bean(name = "apiService")
    public TMDBService tmdbService() {
        TMDBService service = new TMDBServiceImpl();

        return service;
    }

    @Bean(name = "TMDBSearchMovieService")
    public TMDBMovieSearchService movieSearchService() {
        TMDBMovieSearchService service = new TMDBMovieSearchServiceImpl();

        return service;
    }
}
