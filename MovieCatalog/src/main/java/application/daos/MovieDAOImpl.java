package application.daos;

import application.entities.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository("movieDAO")
public class MovieDAOImpl implements MovieDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void saveMovie(Movie movie) {
        em.persist(movie);
        em.flush();
    }

    //TODO
    @Override
    public void saveAllMovies(Collection<Movie> movies) {

    }
}
