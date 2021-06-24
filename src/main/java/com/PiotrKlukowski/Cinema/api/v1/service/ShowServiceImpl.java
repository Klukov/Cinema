package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.request.ShowRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.converter.MovieResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.converter.SeatResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.converter.ShowResponseConverter;
import com.PiotrKlukowski.Cinema.api.v1.response.MovieResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.SeatResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.ShowResponseModel;
import com.PiotrKlukowski.Cinema.exception.CinemaException;
import com.PiotrKlukowski.Cinema.exception.InvalidRequestException;
import com.PiotrKlukowski.Cinema.exception.NotFoundException;
import com.PiotrKlukowski.Cinema.model.Movie;
import com.PiotrKlukowski.Cinema.model.Room;
import com.PiotrKlukowski.Cinema.model.Show;
import com.PiotrKlukowski.Cinema.model.Ticket;
import com.PiotrKlukowski.Cinema.repository.CinemaRepository;
import com.PiotrKlukowski.Cinema.repository.MovieRepository;
import com.PiotrKlukowski.Cinema.repository.RoomRepository;
import com.PiotrKlukowski.Cinema.repository.SeatRepository;
import com.PiotrKlukowski.Cinema.repository.ShowRepository;
import com.PiotrKlukowski.Cinema.repository.TicketRepository;
import com.PiotrKlukowski.Cinema.typeList.AudioType;
import com.PiotrKlukowski.Cinema.typeList.Language;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import com.PiotrKlukowski.Cinema.typeList.TicketStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ShowServiceImpl implements ShowService {

    public final static Duration SHOW_REQUEST_QUERY_BACKWARD_TIME_MARGIN = Duration.ofMinutes(15);

    private final ShowRepository showRepository;
    private final MovieRepository movieRepository;
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;
    private final TicketRepository ticketRepository;
    private final CinemaRepository cinemaRepository;

    @Override
    public Set<MovieResponseModel> findAllMovies() {
        return movieRepository.findAll().stream()
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
