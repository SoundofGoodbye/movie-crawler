package moviecrawler.crawlers;

import java.io.IOException;
import java.util.List;

public interface Crawler {
    List<String> getMovies(URLEnums url) throws IOException;
}
