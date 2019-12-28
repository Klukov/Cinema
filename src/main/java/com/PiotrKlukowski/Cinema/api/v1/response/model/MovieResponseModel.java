package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class MovieResponseModel {

    @Getter
    private Integer id;

    @Getter
    private String title;

    @Getter
    private String description;

    @Getter
    private Integer lengthMinutes;
}
