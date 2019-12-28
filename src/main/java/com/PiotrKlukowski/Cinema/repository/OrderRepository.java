package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Reservation, String> {
}
