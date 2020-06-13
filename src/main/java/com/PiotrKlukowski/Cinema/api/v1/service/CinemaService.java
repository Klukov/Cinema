package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.response.model.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.RoomResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel;

import java.util.Set;

public interface CinemaService {

    Set<CinemaResponseModel> findAllCinemas();

    Set<TicketTypeResponseModel> getAllTicketTypes();

    Set<RoomResponseModel> findAllRoomsInCinema(Integer cinemaId);
}
