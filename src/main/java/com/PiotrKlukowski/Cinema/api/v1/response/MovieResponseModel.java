package com.PiotrKlukowski.Cinema.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class MovieResponseModel {
    private final Integer id;
    private final String title;
    private final String description;
    private final Integer lengthMinutes;
}
