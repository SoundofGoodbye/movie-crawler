package application.repositories;

import application.entities.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Override
    List<Movie> findAll(Sort sort);

    List<Movie> findByReleaseDateAfter(LocalDate releaseDate);
}

