package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.response.SeatResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.ShowResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.service.ShowService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="cinema/api/v1/", produces="application/json")
@AllArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping("cinema/{id}/shows")
    public List<ShowResponseModel> getShows(
            @PathVariable(value = "id") Integer cinemaId,
            @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFrom,
            @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTo) {
        if (dateFrom == null && dateTo == null) {
            return showService.findAllPlannedShowsInCinema(cinemaId).stream()
                    .sorted(Comparator.comparing(ShowResponseModel::getStartTime))
                    .collect(Collectors.toList());
        } else {
            showService.validateShowRequestDateTimeParameters(cinemaId, dateFrom, dateTo);
            return showService.findShowsInCinemaInTime(cinemaId, dateFrom, dateTo).stream()
                    .sorted(Comparator.comparing(ShowResponseModel::getStartTime))
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("show/{id}/seats")
    public Set<SeatResponseModel> getSeats(@PathVariable(value = "id") String showId) {
        return showService.findAllTicketsInShow(showId);
    }
}
