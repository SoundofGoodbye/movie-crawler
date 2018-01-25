package moviecrawler.schedulers;

import moviecrawler.URLEnums;
import moviecrawler.crawlers.BasicWebCrawler;
import moviecrawler.daos.MovieDAO;
import moviecrawler.dtos.MovieDTO;
import moviecrawler.entities.Movie;
import moviecrawler.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Scheduler {

    @Autowired
    MovieRepository movieRepository;

    @Scheduled(fixedRate = 3_600_000)
    public void populateMovies() throws IOException {
        for (URLEnums url : URLEnums.values()) {
            final List<MovieDTO> pageLinks = new BasicWebCrawler().getMovieTitles(url.getValue());
            Set<Movie> moviesInDatabase = new HashSet<Movie>(movieRepository.findAll());

            for (MovieDTO movieDTO : pageLinks) {
                if (!moviesInDatabase.contains(new Movie(movieDTO.getTitle()))) {
                    movieRepository.saveAndFlush(new Movie(movieDTO.getTitle()));
                }
            }
        }
    }
}
