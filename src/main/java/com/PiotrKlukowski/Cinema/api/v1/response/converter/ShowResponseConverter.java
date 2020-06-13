package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.ShowResponseModel;
import com.PiotrKlukowski.Cinema.model.Show;

public class ShowResponseConverter {

    public static ShowResponseModel convert (Show show) {
        return new ShowResponseModel(
                show.getId(),
                show.getMovie().getId(),
                show.getAudioLanguage().getCode(),
                show.getAudioType().name(),
                show.getSubtitlesLanguage() == null ? null : show.getSubtitlesLanguage().getCode(),
                show.getStartTime());
    }
}
