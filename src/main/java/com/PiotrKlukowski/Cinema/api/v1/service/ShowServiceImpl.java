package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.request.model.ShowRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.converter.MovieResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.converter.SeatResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.converter.ShowResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.model.MovieResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.SeatResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.ShowResponseModel;
import com.PiotrKlukowski.Cinema.exception.CinemaException;
import com.PiotrKlukowski.Cinema.exception.InvalidRequestException;
import com.PiotrKlukowski.Cinema.exception.NotFoundException;
import com.PiotrKlukowski.Cinema.model.Movie;
import com.PiotrKlukowski.Cinema.model.Room;
import com.PiotrKlukowski.Cinema.model.Show;
import com.PiotrKlukowski.Cinema.model.Ticket;
import com.PiotrKlukowski.Cinema.repository.*;
import com.PiotrKlukowski.Cinema.typeList.AudioType;
import com.PiotrKlukowski.Cinema.typeList.Language;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import com.PiotrKlukowski.Cinema.typeList.TicketStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.PiotrKlukowski.Cinema.constance.Constance.SHOW_REQUEST_QUERY_BACKWARD_TIME_MARGIN;

@Service
public class ShowServiceImpl implements ShowService {

    private ShowRepository showRepository;
    private MovieRepository movieRepository;
    private RoomRepository roomRepository;
    private SeatRepository seatRepository;
    private TicketRepository ticketRepository;
    private CinemaRepository cinemaRepository;

    public ShowServiceImpl(
            ShowRepository showRepository,
            MovieRepository movieRepository,
            RoomRepository roomRepository,
            SeatRepository seatRepository,
            TicketRepository ticketRepository,
            CinemaRepository cinemaRepository) {
        this.showRepository = showRepository;
        this.movieRepository = movieRepository;
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
        this.ticketRepository = ticketRepository;
        this.cinemaRepository = cinemaRepository;
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
        return showRepository.findAllByRoomCinemaIdAndStartTimeIsAfter(cinemaId, LocalDateTime.now()).stream()
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

    @Override
    @Transactional
    public void createNewShow(ShowRequestModel showRequestModel) {
        Movie movie = movieRepository.findById(showRequestModel.getMovieId())
                .orElseThrow();
        Room room = roomRepository.findById(showRequestModel.getRoomId())
                .orElseThrow();
        Show show = Show.builder()
                .movie(movie)
                .room(room)
                .subtitlesLanguage(Language.getLanguageFromCode(showRequestModel.getSubtitlesLanguage()))
                .startTime(showRequestModel.getStartTime())
                .audioLanguage(Language.getLanguageFromCode(showRequestModel.getAudioLanguage()))
                .audioType(AudioType.getAudioTypeFromName(showRequestModel.getAudioType()))
                .build();
        showRepository.save(show);
        ticketRepository.saveAll(seatRepository.findAllByRoomEquals(room).stream().map(seat -> Ticket.builder()
                .row(seat.getRow())
                .column(seat.getColumn())
                .seatType(seat.getSeatType())
                .show(show)
                .ticketStatus(TicketStatus.FREE)
                .build()).collect(Collectors.toList()));
    }

    @Override
    public void validateShowRequestDateTimeParameters(Integer cinemaId, LocalDateTime from, LocalDateTime to) throws CinemaException {
        if (from.isAfter(to)) { throw new InvalidRequestException("Time from should be before time to"); }
        ZoneId timeZone = ZoneId.of(cinemaRepository.findById(cinemaId)
                .orElseThrow(() -> new NotFoundException("Cinema with id " + cinemaId + "does not exist"))
                .getTimeZoneName());
        if (ZonedDateTime.now().minus(SHOW_REQUEST_QUERY_BACKWARD_TIME_MARGIN).isAfter(ZonedDateTime.of(from, timeZone))) {
            throw new InvalidRequestException("You cannot query archived shows");
        }
    }
}
