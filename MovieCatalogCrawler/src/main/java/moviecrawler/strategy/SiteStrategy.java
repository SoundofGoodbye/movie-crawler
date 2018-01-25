package moviecrawler.strategy;

import moviecrawler.dtos.MovieDTO;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SiteStrategy {

    private Crawlable crawlable;

    public List<MovieDTO> processUrl(String url, Set<String> links, List<MovieDTO> movies) throws IOException {
        switch (url) {
            case "https://www.fandango.com/moviesintheaters/":
                crawlable = new FandangoCrawler();
                break;
            default:
                throw new IllegalArgumentException("No implementation for given crawler");
        }
        return crawlable.crawl(links,movies);
    }


}
