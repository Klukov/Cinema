package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.response.model.RoomResponseModel;

import java.util.Set;

public interface AllRoomsInCinemaQuery {

    Set<RoomResponseModel> findAllRoomsInCinema(Integer cinemaId);
}
