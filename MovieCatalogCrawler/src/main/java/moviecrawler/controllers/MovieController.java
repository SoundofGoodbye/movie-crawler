//TODO REMOVE
//package moviecrawler.controllers;
//
//import moviecrawler.crawlers.BasicWebCrawler;
//import moviecrawler.daos.MovieDAO;
//import moviecrawler.dtos.MovieDTO;
//import moviecrawler.dtos.SiteDTO;
//import moviecrawler.entities.Movie;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class MovieController {
//
//    @Autowired
//    MovieDAO movieDAO;
//
//    @RequestMapping(value = "/movies", method = RequestMethod.GET)
//    public ResponseEntity<List<MovieDTO>> getMovies(@RequestParam String url) throws IOException {
//
//        final List<MovieDTO> pageLinks = new BasicWebCrawler().getMovieTitles(url);
//        pageLinks.stream().map(m -> new Movie(m.getTitle())).collect(Collectors.toList()).forEach(m -> movieDAO.create(m));
//
//        return new ResponseEntity<>(pageLinks, HttpStatus.OK);
//    }
//
//}
//
//
//
