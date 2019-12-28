package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.response.model.SeatResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.ShowResponseModel;
import com.PiotrKlukowski.Cinema.service.ShowService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="cinema/api/v1/", produces="application/json")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("cinema/{id}/shows")
    public List<ShowResponseModel> getShows(
            @PathVariable(value = "id") Integer cinemaId,
            @RequestParam(value = "from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        return showService.findShowsInCinemaInTime(cinemaId, dateFrom, dateTo).stream()
                .sorted(Comparator.comparing(ShowResponseModel::getStartTime))
                .collect(Collectors.toList());
    }

    @GetMapping("show/{id}/seats")
    public Set<SeatResponseModel> getSeats(@PathVariable(value = "id") String showId) {
        return showService.findAllTicketsInShow(showId);
    }
}