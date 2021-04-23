package com.PiotrKlukowski.Cinema.dataLoader;

import com.PiotrKlukowski.Cinema.model.Room;
import com.PiotrKlukowski.Cinema.model.Seat;
import com.PiotrKlukowski.Cinema.repository.CinemaRepository;
import com.PiotrKlukowski.Cinema.repository.MovieRepository;
import com.PiotrKlukowski.Cinema.repository.OrderRepository;
import com.PiotrKlukowski.Cinema.repository.PersonRepository;
import com.PiotrKlukowski.Cinema.repository.RoomRepository;
import com.PiotrKlukowski.Cinema.repository.ShowRepository;
import com.PiotrKlukowski.Cinema.repository.TicketRepository;
import com.PiotrKlukowski.Cinema.typeList.SeatType;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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

    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final OrderRepository orderRepository;
    private final PersonRepository personRepository;
    private final ShowRepository showRepository;
    private final TicketRepository ticketRepository;
    private final RoomRepository roomRepository;

    @Override
    public void run(String... args) {
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
        var numberOfColumns = ThreadLocalRandom.current().nextInt(columnsMin, columnsMax + 1);
        var numberOfRows = ThreadLocalRandom.current().nextInt(rowsMin, rowsMax + 1);
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
