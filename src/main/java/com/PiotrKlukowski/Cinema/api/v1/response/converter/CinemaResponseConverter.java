package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.model.Cinema;

public class CinemaResponseConverter {

    public static CinemaResponseModel convert(Cinema cinema) {
        return new CinemaResponseModel(
                cinema.getId(),
                cinema.getName(),
                cinema.getCity(),
                cinema.getPostalCode(),
                cinema.getAddress(),
                cinema.getPhoneNumber(),
                cinema.getEmail());
    }
}
