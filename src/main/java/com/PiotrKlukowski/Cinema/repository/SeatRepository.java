package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Room;
import com.PiotrKlukowski.Cinema.model.Seat;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SeatRepository extends CrudRepository<Seat, Long> {

    Set<Seat> findAllByRoomEquals(Room room);
}
