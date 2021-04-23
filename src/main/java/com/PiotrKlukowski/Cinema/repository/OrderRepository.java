package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Reservation, String> {
}
