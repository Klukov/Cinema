package com.PiotrKlukowski.Cinema.dataLoader;

import com.PiotrKlukowski.Cinema.model.Room;
import com.PiotrKlukowski.Cinema.model.Seat;
import com.PiotrKlukowski.Cinema.repository.*;
import com.PiotrKlukowski.Cinema.typeList.SeatType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

@Order(value = 2)
@Component
@ConditionalOnProperty(name = "app.initial-db-load", havingValue = "true")
@Slf4j
public class RepositoryDataLoader implements CommandLineRunner {

    @Value("${app.initialData.room.size.columns.max}")
    private Integer columnsMax;

    @Value("${app.initialData.room.size.columns.min}")
    private Integer columnsMin;

    @Value("${app.initialData.room.size.rows.max}")
    private Integer rowsMax;

    @Value("${app.initialData.room.size.rows.min}")
    private Integer rowsMin;

    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;
    private OrderRepository orderRepository;
    private PersonRepository personRepository;
    private ShowRepository showRepository;
    private TicketRepository ticketRepository;
    private RoomRepository roomRepository;

    public RepositoryDataLoader(
            CinemaRepository cinemaRepository,
            MovieRepository movieRepository,
            OrderRepository orderRepository,
            PersonRepository personRepository,
            ShowRepository showRepository,
            TicketRepository ticketRepository,
            RoomRepository roomRepository) {
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
        this.showRepository = showRepository;
        this.ticketRepository = ticketRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createSeats();
    }

    @Transactional
    void createSeats() {
        roomRepository.findAll().forEach(room -> {
            createRandomSeats(room);
            roomRepository.save(room);
        });
    }

    private void createRandomSeats(Room room) {
        Set<Seat> newSeats = new HashSet<>();
        Integer numberOfColumns = ThreadLocalRandom.current().nextInt(columnsMin, columnsMax + 1);
        Integer numberOfRows = ThreadLocalRandom.current().nextInt(rowsMin, rowsMax + 1);
        IntStream.range(1, numberOfColumns + 1).forEach(columnNumber -> {
            IntStream.range(1, numberOfRows + 1).forEach(rowNumber -> {
                Seat seat = Seat.builder()
                        .column(columnNumber)
                        .row(rowNumber)
                        .room(room)
                        .seatType(SeatType.NORMAL)
                        .build();
                newSeats.add(seat);
            });
        });
        room.setSeats(newSeats);
    }
}
