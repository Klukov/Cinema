package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
public final class ShowResponseModel {

    @Getter
    private String id;

    @Getter
    private Integer movieId;

    @Getter
    private String audioLanguage;

    @Getter
    private String audioType;

    @Getter
    private String subtitlesLanguage;

    @Getter
    private LocalDateTime startTime;
}
