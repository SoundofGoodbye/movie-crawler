package application.repositories;
 
import application.entities.Movie;
import org.springframework.data.repository.CrudRepository;
 
public interface MovieRepository extends CrudRepository<Movie,Integer> {
    
}