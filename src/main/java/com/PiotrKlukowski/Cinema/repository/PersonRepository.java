package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Buyer;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Buyer, String> {
}
