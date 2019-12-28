package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@AllArgsConstructor
public final class ShowResponseModel {

    @Getter
    private String id;

    @Getter
    private String movieName;

    @Getter
    private Integer movieLength;

    @Getter
    private String movieDescription;

    @Getter
    private String audioLanguage;

    @Getter
    private String subtitlesLanguage;

    @Getter
    private ZonedDateTime startTime;
}
