package moviecrawler.schedulers;

import moviecrawler.crawlers.Crawler;
import moviecrawler.crawlers.URLEnums;
import moviecrawler.crawlers.BasicWebCrawler;
import moviecrawler.entities.Movie;
import moviecrawler.services.MessageBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@Component
@PropertySource("classpath:scheduler.properties")
public class Scheduler {

    private final static String TITLES_QUEUE = "titlesQueue";

    @Autowired
    private MessageBrokerService messageBrokerService;

    @Autowired
    private MovieService movieService;

    @Scheduled(fixedDelayString = "${schedule.timer}")
    @Transactional
    public void populateMovies() throws IOException,TimeoutException {
        Crawler crawler = new BasicWebCrawler();

        for (URLEnums url : URLEnums.values()) {
            Set<Movie> moviesInDatabase = movieService.findAll();
            final List<String> crawledMovies = crawler.getMovies(url);

            List<String> moviesInDatabaseTitles = moviesInDatabase.stream()
                    .map(Movie::getTitle)
                    .collect(Collectors.toList());

            movieService.filterAndSaveNewMovies(crawledMovies, moviesInDatabaseTitles);

            movieService.deleteExpiredMovies(crawledMovies, moviesInDatabaseTitles);

            messageBrokerService.sendTitlesToMessageQueue(crawledMovies,TITLES_QUEUE);
        }
    }







}
