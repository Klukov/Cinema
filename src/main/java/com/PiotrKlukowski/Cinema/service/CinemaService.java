package com.PiotrKlukowski.Cinema.service;

import com.PiotrKlukowski.Cinema.api.v1.response.model.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel;

import java.util.Set;

public interface CinemaService {

    Set<CinemaResponseModel> findAllCinemas();

    Set<TicketTypeResponseModel> getAllTicketTypes();
}
