package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Room;
import com.PiotrKlukowski.Cinema.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    Set<Seat> findAllByRoomEquals(Room room);
}
