package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CinemaResponseModel {

    @Getter
    private Integer id;

    @Getter
    private String name;

    @Getter
    private String city;

    @Getter
    private String postalCode;

    @Getter
    private String address;

    @Getter
    private String phoneNumber;

    @Getter
    private String email;
}
