package moviecrawler.crawlers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface Crawlable {

    List<String> crawl(Set<String> links, List<String> movies) throws IOException;

}
