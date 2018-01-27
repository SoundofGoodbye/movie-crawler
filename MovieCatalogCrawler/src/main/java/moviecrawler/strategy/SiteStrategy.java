package moviecrawler.strategy;

import moviecrawler.crawlers.Crawlable;
import moviecrawler.crawlers.FandangoCrawler;
import moviecrawler.crawlers.URLEnums;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class SiteStrategy {

    private Crawlable crawlable;

    public List<String> processUrl(URLEnums url, Set<String> links, List<String> movies) throws IOException {
        switch (url) {
            case FANDANGO:
                crawlable = new FandangoCrawler();
                break;
            default:
                throw new IllegalArgumentException("No implementation for given crawler");
        }
        return crawlable.crawl(links, movies);
    }


}
