package moviecrawler.schedulers;

import moviecrawler.crawlers.BasicWebCrawler;
import moviecrawler.crawlers.Crawler;
import moviecrawler.crawlers.URLEnums;
import moviecrawler.services.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;


@Component
@PropertySource("classpath:scheduler.properties")
public class Scheduler {

    @Autowired
    private MessagingService messagingService;

    @Scheduled(fixedDelayString = "${schedule.timer}")
    public void populateMovies() throws IOException {
        Crawler crawler = new BasicWebCrawler();

        List<String> crawledMovies = new ArrayList<>();

        for (URLEnums url : URLEnums.values()) {
            crawledMovies.addAll(crawler.getMovies(url));
        }

        messagingService.sendMessage(crawledMovies);

    }



}
