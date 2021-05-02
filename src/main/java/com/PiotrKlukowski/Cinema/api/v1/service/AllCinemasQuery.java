package com.PiotrKlukowski.Cinema.api.v1.service;

import com.PiotrKlukowski.Cinema.api.v1.response.CinemaResponseModel;

import java.util.Set;

public interface AllCinemasQuery {

    Set<CinemaResponseModel> findAllCinemas();
}
