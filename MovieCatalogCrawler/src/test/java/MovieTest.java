import moviecrawler.MovieCrawlerApplication;
import moviecrawler.daos.MovieDAO;
import moviecrawler.entities.Movie;
import moviecrawler.repositories.MovieRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MovieCrawlerApplication.class, H2JpaConfig.class})
public class MovieTest {

    @Autowired
    private MovieDAO movieDAO;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    @Transactional
    public void testMovieDAO() {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();
        movie3.setTitle("Movie 3");
        movie2.setTitle("Movie 2");
        movie1.setTitle("Movie 1");
        movieRepository.saveAndFlush(movie1);
        movieRepository.saveAndFlush(movie2);
        movieRepository.saveAndFlush(movie3);

        List movies = movieDAO.getMovies();

        Assert.assertEquals(3, movies.size());
    }
}
