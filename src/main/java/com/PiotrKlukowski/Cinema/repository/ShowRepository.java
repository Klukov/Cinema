package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface ShowRepository extends JpaRepository<Show, String> {
    Set<Show> findAllByRoomCinemaIdAndStartTimeBetween(Integer cinemaId, LocalDateTime timeFrom, LocalDateTime timeTo);

    Set<Show> findAllByRoomCinemaIdAndStartTimeIsAfter(Integer room_cinema_id, LocalDateTime startTime);

}
