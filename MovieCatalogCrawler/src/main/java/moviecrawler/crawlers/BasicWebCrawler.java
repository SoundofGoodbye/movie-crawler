package moviecrawler.crawlers;

import moviecrawler.dtos.MovieDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class BasicWebCrawler {
    private HashSet<String> links;
    private List<MovieDTO> movies;

    public BasicWebCrawler() {
        links = new HashSet<>();
        movies = new ArrayList<>();
    }

    public List<MovieDTO> getPageLinks(String URL) {
        try {
            links.add(URL);

            Document document = Jsoup.connect(URL).get();
            Elements linksOnPage = document.select("li.visual-item");

            int counter = 0;
            for (Element page : linksOnPage) {
                //TODO REMOVE
                counter++;
                if(counter==3) {
                    break;
                }
                // =================
                final Elements select = page.getElementsByClass("visual-container");
                final Element element = select.get(0);
                final String movieDetailsUrl = element.attr("href");
                movies.add(processMovieDetails(movieDetailsUrl));
            }

            System.out.println(movies);
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }
        return movies;
    }

    private MovieDTO processMovieDetails(String URL) {
        try {
            Document document = Jsoup.connect(URL).get();
            Elements titleElements = document.select("h1.subnav__title");
            Elements releaseDateElements = document.select("li.movie-details__release-date");
            Elements actorElements = document.select("span.carousel-cast-crew__title");

            final String name = titleElements.get(0).child(0).attr("data-name");
            final String releaseDate = releaseDateElements.get(0).text();
            List<String> actors =  actorElements.stream().map(Element::text).collect(Collectors.toList());

            return new MovieDTO(name,releaseDate,actors);
        } catch (IOException e) {
            System.err.println("For '" + URL + "': " + e.getMessage());
        }
        return null;
    }

}