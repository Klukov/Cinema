package com.PiotrKlukowski.Cinema.service;

import com.PiotrKlukowski.Cinema.api.v1.response.converter.MovieResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.converter.SeatResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.converter.ShowResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.model.MovieResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.SeatResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.ShowResponseModel;
import com.PiotrKlukowski.Cinema.exception.NotFoundException;
import com.PiotrKlukowski.Cinema.repository.MovieRepository;
import com.PiotrKlukowski.Cinema.repository.ShowRepository;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShowServiceImpl implements ShowService {

    private ShowRepository showRepository;
    private MovieRepository movieRepository;

    public ShowServiceImpl(ShowRepository showRepository, MovieRepository movieRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Set<MovieResponseModel> findAllMovies() {
        return StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                .map(MovieResponseConverter::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<MovieResponseModel> findAllMovies(MovieStatus movieStatus) {
        return movieRepository.findAllByStatusEquals(movieStatus).stream()
                .map(MovieResponseConverter::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ShowResponseModel> findAllPlannedShowsInCinema(Integer cinemaId) {
        return showRepository.findAllByStartTimeIsAfterAndRoomCinemaId(ZonedDateTime.now(), cinemaId).stream()
                .map(ShowResponseConverter::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ShowResponseModel> findShowsInCinemaInTime(Integer cinemaId, LocalDateTime from, LocalDateTime to) {
        return showRepository.findAllByRoomCinemaIdAndStartTimeBetween(cinemaId, from, to).stream()
                .map(ShowResponseConverter::convert)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<SeatResponseModel> findAllTicketsInShow(String showId) {
        return showRepository.findById(showId)
                .orElseThrow(() -> new NotFoundException("Show with id " + showId + " does not exist."))
                .getTickets().stream()
                .map(SeatResponseConverter::convert)
                .collect(Collectors.toSet());
    }
}
