package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RoomRepository extends CrudRepository<Room, Integer> {
    Set<Room> findAllByCinema_Id(Integer cinemaId);
}
