package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Movie;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Set<Movie> findAllByStatusEquals(MovieStatus movieStatus);
}
