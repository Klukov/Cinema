package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Set<Room> findAllByCinema_Id(Integer cinemaId);
}
