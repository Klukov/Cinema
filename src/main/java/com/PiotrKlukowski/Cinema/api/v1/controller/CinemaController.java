package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.response.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.TicketTypeResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.service.AllCinemasQuery;
import com.PiotrKlukowski.Cinema.api.v1.service.TicketTypesQuery;
import com.PiotrKlukowski.Cinema.exception.ExceptionDecorator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path="cinema/api/v1/", produces="application/json")
@AllArgsConstructor
public class CinemaController {

    private final AllCinemasQuery allCinemasQuery;
    private final TicketTypesQuery ticketTypesQuery;

    @GetMapping("cinemas")
    public Set<CinemaResponseModel> getAllCinemas() {
        return ExceptionDecorator.wrap(allCinemasQuery::findAllCinemas);
    }

    @GetMapping("ticket-types")
    public Set<TicketTypeResponseModel> getAllTicketTypes() {
        return ExceptionDecorator.wrap(ticketTypesQuery::getAllTicketTypes);
    }
}
