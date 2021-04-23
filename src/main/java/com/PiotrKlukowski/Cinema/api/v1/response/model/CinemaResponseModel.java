package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CinemaResponseModel {
    private final Integer id;
    private final String name;
    private final String city;
    private final String postalCode;
    private final String address;
    private final String phoneNumber;
    private final String email;
}
