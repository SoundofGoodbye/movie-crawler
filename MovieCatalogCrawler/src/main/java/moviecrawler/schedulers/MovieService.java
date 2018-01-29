package moviecrawler.schedulers;

import moviecrawler.entities.Movie;
import moviecrawler.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void filterAndSaveNewMovies(List<String> crawledMovies, List<String> moviesInDatabaseTitles) {
        crawledMovies.stream()
                .filter(m -> !moviesInDatabaseTitles.contains(m))
                .map(Movie::new)
                .forEach(m -> movieRepository.saveAndFlush(m));
    }

    public void deleteExpiredMovies(List<String> crawledMovies, List<String> moviesInDatabaseTitles) {
        moviesInDatabaseTitles.stream()
                .filter(m -> !crawledMovies.contains(m))
                .forEach(m -> movieRepository.deleteMovieByTitle(m));
    }

    public Set<Movie> findAll() {
        return new HashSet<>(movieRepository.findAll());
    }
}
