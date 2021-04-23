package com.PiotrKlukowski.Cinema.dataLoader;

import com.PiotrKlukowski.Cinema.api.v1.request.model.ShowRequestModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.MovieResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.service.AllCinemasQuery;
import com.PiotrKlukowski.Cinema.api.v1.service.AllRoomsInCinemaQuery;
import com.PiotrKlukowski.Cinema.api.v1.service.ShowService;
import com.PiotrKlukowski.Cinema.typeList.AudioType;
import com.PiotrKlukowski.Cinema.typeList.Language;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import com.PiotrKlukowski.Cinema.utils.CollectionsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Order(value = 3)
@Component
@ConditionalOnProperty(name = "app.initial-db-load", havingValue = "true")
@Slf4j
public class ServiceDataLoader implements CommandLineRunner {

    private static final double PROBABILITY_OF_POLISH_AUDIO = 0.7;

    private final ShowService showService;
    private final AllCinemasQuery allCinemasQuery;
    private final AllRoomsInCinemaQuery allRoomsInCinemaQuery;

    public ServiceDataLoader(ShowService showService, AllCinemasQuery allCinemasQuery, AllRoomsInCinemaQuery allRoomsInCinemaQuery) {
        this.showService = showService;
        this.allCinemasQuery = allCinemasQuery;
        this.allRoomsInCinemaQuery = allRoomsInCinemaQuery;
    }

    @Override
    public void run(String... args) {
        createShowsWithTickets();
    }

    void createShowsWithTickets() {
        Set<Integer> availableMovies = showService.findAllMovies(MovieStatus.AVAILABLE).stream().map(MovieResponseModel::getId).collect(Collectors.toSet());
        allCinemasQuery.findAllCinemas().forEach(cinema -> {
            allRoomsInCinemaQuery.findAllRoomsInCinema(cinema.getId()).forEach(roomResponseModel -> {
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().minusHours(48).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().minusHours(44).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().minusHours(28).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().minusHours(24).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().minusHours(5).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().minusHours(1).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(3).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(8).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(22).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(26).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(45).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(50).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(71).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(75).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(79).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(95).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(99).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(116).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(120).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(124).plusMinutes(new Random().nextInt(60)));
                createShow(CollectionsUtils.getRandomElement(availableMovies), roomResponseModel.getId(), LocalDateTime.now().plusHours(129).plusMinutes(new Random().nextInt(60)));
            });
        });
    }

    private void createShow(Integer movieId, Integer roomId, LocalDateTime startTime) {
        Language audioLanguage, subtitlesLanguage;
        AudioType audioType;
        if (Math.random() - PROBABILITY_OF_POLISH_AUDIO < 0) {
            audioLanguage = Language.POLISH;
            audioType = CollectionsUtils.getRandomElement(Arrays.asList(AudioType.values()));
            subtitlesLanguage = null;
        } else {
            audioLanguage = Language.ENGLISH;
            subtitlesLanguage = Language.POLISH;
            audioType = AudioType.ORIGINAL;
        }
        showService.createNewShow(ShowRequestModel.builder()
                .movieId(movieId)
                .roomId(roomId)
                .startTime(startTime)
                .audioLanguage(audioLanguage.getCode())
                .audioType(audioType.name())
                .subtitlesLanguage(subtitlesLanguage != null ? subtitlesLanguage.getCode() : null)
                .build());
    }


}
