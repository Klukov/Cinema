package com.PiotrKlukowski.Cinema.api.v1.request.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
public class ShowRequestModel {

    @Getter
    private Integer roomId;

    @Getter
    private Integer movieId;

    @Getter
    private LocalDateTime startTime;

    @Getter
    @NotNull
    private String audioLanguage;

    @Getter
    @NotNull
    private String audioType;

    @Getter
    private String subtitlesLanguage;
}
