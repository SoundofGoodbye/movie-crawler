package application.services.movies.impl;

import application.models.movies.Movie;
import application.services.movies.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Value("${movie.webcrawler.url}")
    private String webcrawlerUrl;

    @Override
    public List<Movie> getAllMoviesFrom(String sourceId) {
        RestTemplate restTemplate = new RestTemplate();
      /*  CardDetailsResponse cardDetails = restTemplate.getForObject(
                "localhost:9001",
                CardDetailsResponse.class);*/



        List<Movie> movies = new ArrayList<>();
        List<String> actorNames = new ArrayList<>();
        actorNames.add(webcrawlerUrl);
        Movie movie = new Movie("Pirates of the Caribean", "2010", actorNames);
        movies.add(movie);

        return movies;
    }
}
