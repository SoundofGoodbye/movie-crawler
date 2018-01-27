package moviecrawler.crawlers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class FandangoCrawler implements Crawlable {

    private String url = URLEnums.FANDANGO.getValue();

    @Override
    public List<String> crawl(Set<String> links, List<String> movies) throws IOException {
        try {
            links.add(url);

            Document document = Jsoup.connect(url).get();
            Elements linksOnPage = document.select("li.visual-item");

            for (Element page : linksOnPage) {
                final Elements select = page.getElementsByClass("visual-container");
                final Element element = select.get(0);
                final String movieDetailsUrl = element.attr("href");
                movies.add(processMovieDetails(movieDetailsUrl));
            }
        } catch (IOException e) {
            throw new IOException("Failed to crawl site: " + url);
        }
        return movies;
    }

    private String processMovieDetails(String URL) {
        try {
            Document document = Jsoup.connect(URL).get();
            Elements titleElements = document.select("h1.subnav__title");

            final String name = titleElements.get(0).child(0).attr("data-name");

            return name;
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }
        return null;
    }
}

