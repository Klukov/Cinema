package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public final class ShowResponseModel {
    private final String id;
    private final Integer movieId;
    private final String audioLanguage;
    private final String audioType;
    private final String subtitlesLanguage;
    private final LocalDateTime startTime;
}
