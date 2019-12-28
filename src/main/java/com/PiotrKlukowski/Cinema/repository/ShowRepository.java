package com.PiotrKlukowski.Cinema.repository;

import com.PiotrKlukowski.Cinema.model.Show;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;

public interface ShowRepository extends CrudRepository<Show, String> {
    Set<Show> findAllByRoomCinemaIdAndStartTimeBetween(Integer cinemaId, LocalDateTime timeFrom, LocalDateTime timeTo);

    Set<Show> findAllByStartTimeIsAfterAndRoomCinemaId(ZonedDateTime timeFrom, Integer cinemaID);
}
