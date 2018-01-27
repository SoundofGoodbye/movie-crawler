package moviecrawler.crawlers;

import moviecrawler.strategy.SiteStrategy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BasicWebCrawler implements Crawler {
    private HashSet<String> links;
    private List<String> movies;

    public BasicWebCrawler() {
        links = new HashSet<>();
        movies = new ArrayList<>();
    }

    @Override
    public List<String> getMovies(URLEnums url) throws IOException {
        SiteStrategy siteStrategy = new SiteStrategy();
        return siteStrategy.processUrl(url, links, movies);
    }

}