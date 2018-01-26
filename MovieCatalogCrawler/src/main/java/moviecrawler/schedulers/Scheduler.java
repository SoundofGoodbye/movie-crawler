package moviecrawler.schedulers;

import moviecrawler.crawlers.Crawler;
import moviecrawler.crawlers.URLEnums;
import moviecrawler.crawlers.BasicWebCrawler;
import moviecrawler.entities.Movie;
import moviecrawler.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@PropertySource("classpath:scheduler.properties")
public class Scheduler {

    @Autowired
    private MovieRepository movieRepository;

    @Scheduled(fixedDelayString = "${schedule.timer}")
    @Transactional
    public void populateMovies() throws IOException {
        for (URLEnums url : URLEnums.values()) {
            Crawler crawler = new BasicWebCrawler();
            Set<Movie> moviesInDatabase = new HashSet<>(movieRepository.findAll());
            final List<String> crawledMovies = crawler.getMovies(url);

            List<String> moviesInDatabaseTitles = moviesInDatabase.stream()
                    .map(Movie::getTitle)
                    .collect(Collectors.toList());

            //Filter and save the new movie titles
            crawledMovies.stream()
                    .filter(m -> !moviesInDatabaseTitles.contains(m))
                    .map(Movie::new)
                    .forEach(m -> movieRepository.saveAndFlush(m));

            //Delete the expired movies
            moviesInDatabaseTitles.stream()
                    .filter(m -> !crawledMovies.contains(m))
                    .forEach(m -> movieRepository.deleteMovieByTitle(m));

        }
    }

}
