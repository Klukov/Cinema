package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.request.model.ShowRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.MovieResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.SeatResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.ShowResponseModel;
import com.PiotrKlukowski.Cinema.exception.CinemaException;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;

import java.time.LocalDateTime;
import java.util.Set;

public interface ShowService {

    Set<MovieResponseModel> findAllMovies();

    Set<MovieResponseModel> findAllMovies(MovieStatus movieStatus);

    Set<ShowResponseModel> findAllPlannedShowsInCinema(Integer cinemaId);

    Set<ShowResponseModel> findShowsInCinemaInTime(Integer cinemaId, LocalDateTime from, LocalDateTime to);

    Set<SeatResponseModel> findAllTicketsInShow(String showId);

    void createNewShow(ShowRequestModel showRequestModel);

    void validateShowRequestDateTimeParameters(Integer cinemaId, LocalDateTime from, LocalDateTime to) throws CinemaException;
}
