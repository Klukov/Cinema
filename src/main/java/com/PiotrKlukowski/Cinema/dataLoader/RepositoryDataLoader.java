package com.PiotrKlukowski.Cinema.dataLoader;

import com.PiotrKlukowski.Cinema.model.Room;
import com.PiotrKlukowski.Cinema.model.Seat;
import com.PiotrKlukowski.Cinema.repository.*;
import com.PiotrKlukowski.Cinema.typeList.SeatType;
import lombok.extern.slf4j.Slf4j;
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
@ConditionalOnProperty(name = "app.test-db-load", havingValue = "true")
@Slf4j
public class RepositoryDataLoader implements CommandLineRunner {

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
            createRandomSeats(room, 8,16,10,16);
            roomRepository.save(room);
        });
    }

    private void createRandomSeats(Room room, Integer minColumns, Integer maxColumns, Integer minRows, Integer maxRows) {
        Set<Seat> newSeats = new HashSet<>();
        Integer numberOfColumns = ThreadLocalRandom.current().nextInt(minColumns, maxColumns + 1);
        Integer numberOfRows = ThreadLocalRandom.current().nextInt(minRows, maxRows + 1);
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
