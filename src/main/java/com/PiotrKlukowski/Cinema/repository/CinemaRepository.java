package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

}
