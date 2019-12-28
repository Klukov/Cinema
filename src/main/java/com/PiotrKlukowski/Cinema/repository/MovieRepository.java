package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Movie;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    Set<Movie> findAllByStatusEquals(MovieStatus movieStatus);
}
