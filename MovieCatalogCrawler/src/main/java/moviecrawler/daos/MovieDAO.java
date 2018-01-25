package moviecrawler.daos;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import moviecrawler.entities.Movie;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
@Transactional
public class MovieDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Movie> getMovies() {
        Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Movie.class);
        return criteria.list();
    }
}
