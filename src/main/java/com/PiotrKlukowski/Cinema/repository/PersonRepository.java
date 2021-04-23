package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Buyer, String> {
}
