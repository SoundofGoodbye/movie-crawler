package moviecrawler.controllers;

import moviecrawler.crawlers.BasicWebCrawler;
import moviecrawler.dtos.MovieDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {


    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public ResponseEntity<List<MovieDTO>> getMovies() {

        final List<MovieDTO> pageLinks = new BasicWebCrawler().getPageLinks("https://www.fandango.com/moviesintheaters/");
        return new ResponseEntity<>(pageLinks, HttpStatus.OK);
    }

}



