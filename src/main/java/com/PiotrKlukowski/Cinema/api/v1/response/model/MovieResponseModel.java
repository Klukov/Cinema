package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MovieResponseModel {
    private final Integer id;
    private final String title;
    private final String description;
    private final Integer lengthMinutes;
}
