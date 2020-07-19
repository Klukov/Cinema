package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.response.model.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.service.CinemaService;
import com.PiotrKlukowski.Cinema.exception.ExceptionDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path="cinema/api/v1/", produces="application/json")
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("cinemas")
    public Set<CinemaResponseModel> getAllCinemas() {
        return ExceptionDecorator.wrap(cinemaService::findAllCinemas);
    }

    @GetMapping("ticket-types")
    public Set<TicketTypeResponseModel> getAllTicketTypes() {
        return ExceptionDecorator.wrap(cinemaService::getAllTicketTypes);
    }
}
