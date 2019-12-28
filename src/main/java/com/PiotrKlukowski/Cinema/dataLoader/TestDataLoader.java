package com.PiotrKlukowski.Cinema.dataLoader;

import com.PiotrKlukowski.Cinema.model.Movie;
import com.PiotrKlukowski.Cinema.repository.*;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.test-db-load", havingValue = "true")
public class TestDataLoader implements CommandLineRunner {
    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;
    private OrderRepository orderRepository;
    private PersonRepository personRepository;
    private ShowRepository showRepository;
    private TicketRepository ticketRepository;

    public TestDataLoader(
            CinemaRepository cinemaRepository,
            MovieRepository movieRepository,
            OrderRepository orderRepository,
            PersonRepository personRepository,
            ShowRepository showRepository,
            TicketRepository ticketRepository) {
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.orderRepository = orderRepository;
        this.personRepository = personRepository;
        this.showRepository = showRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //this.movieRepository.deleteAll();
        Movie movie = Movie.builder()
                .title("Movie test")
                .description("test from app runner")
                .lengthMinutes(999)
                .status(MovieStatus.AVAILABLE)
                .build();
        this.movieRepository.save(movie);
    }
}
