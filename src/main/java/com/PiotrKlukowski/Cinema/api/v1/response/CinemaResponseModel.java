package com.PiotrKlukowski.Cinema.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class CinemaResponseModel {
    private final Integer id;
    private final String name;
    private final String city;
    private final String postalCode;
    private final String address;
    private final String phoneNumber;
    private final String email;
}
