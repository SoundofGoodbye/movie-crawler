package com.apiservice.configuration;

import com.apiservice.engine.SearchEngine;
import com.apiservice.engine.impl.SearchEngineImpl;
import com.apiservice.services.TMDBService;
import com.apiservice.services.TMDBServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
/**
 * Project specific configuration.
 */
public class ProjectBeanConfiguration {

    @Bean(name = "apiService")
    public TMDBService tmdbService() {
        TMDBService service = new TMDBServiceImpl();

        return service;
    }

    @Bean(name = "SearchEngine")
    public SearchEngine searchEngine() {
        SearchEngine searchEngine = new SearchEngineImpl();

        return searchEngine;
    }
}
