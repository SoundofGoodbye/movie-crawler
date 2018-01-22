package application.repositories;
 
import application.entities.Movie;
import org.springframework.data.repository.CrudRepository;
 
public interface CountryRepository extends CrudRepository<Movie,Integer> {
    
}