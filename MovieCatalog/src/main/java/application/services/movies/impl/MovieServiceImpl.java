package application.services.movies.impl;

import application.models.movies.MovieDTO;
import application.services.movies.MovieService;
import com.apiservice.services.movies.TMDBMovieSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {
    @Value("${movie.webcrawler.url}")
    private String webcrawlerUrl;

    @Autowired
    @Qualifier(value = "TMDBSearchMovieService")
    private TMDBMovieSearchService tmdbMovieSearchService;

    @Override
    public String searchMovie(String query, String language, int page, boolean includeAdults, String region, int year, int primaryReleaseDate) {
        //TODO: Result should probably be converted here on in the controller that called this method.
        return tmdbMovieSearchService.getMovie(query, language, page, includeAdults, region, year, primaryReleaseDate);
    }
}
