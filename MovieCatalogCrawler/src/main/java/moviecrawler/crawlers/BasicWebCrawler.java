package moviecrawler.crawlers;

import moviecrawler.dtos.MovieDTO;
import moviecrawler.strategy.SiteStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BasicWebCrawler {
    private HashSet<String> links;
    private List<MovieDTO> movies;

    public BasicWebCrawler() {
        links = new HashSet<>();
        movies = new ArrayList<>();
    }

    public List<MovieDTO> getMovieTitles(String url) throws IOException {
        SiteStrategy siteStrategy = new SiteStrategy();
        return siteStrategy.processUrl(url, links, movies);
    }

}