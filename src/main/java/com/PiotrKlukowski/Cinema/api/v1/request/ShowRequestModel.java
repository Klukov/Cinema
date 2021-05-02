package com.PiotrKlukowski.Cinema.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class ShowRequestModel {

    private final Integer roomId;

    private final Integer movieId;

    private final LocalDateTime startTime;

    @NotNull
    private final String audioLanguage;

    @NotNull
    private final String audioType;

    private final String subtitlesLanguage;
}
