package moviecrawler.strategy;

import moviecrawler.dtos.MovieDTO;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface Crawlable {

    List<MovieDTO> crawl(Set<String> links, List<MovieDTO> movies) throws IOException;

}
