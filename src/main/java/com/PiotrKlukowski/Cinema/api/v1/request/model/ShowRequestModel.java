package com.PiotrKlukowski.Cinema.api.v1.request.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
public class ShowRequestModel {

    private Integer roomId;

    private Integer movieId;

    private LocalDateTime startTime;

    @NotNull
    private String audioLanguage;

    @NotNull
    private String audioType;

    private String subtitlesLanguage;
}
