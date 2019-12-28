package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.ShowResponseModel;
import com.PiotrKlukowski.Cinema.model.Show;

public class ShowResponseConverter {

    public static ShowResponseModel convert (Show show) {
        return new ShowResponseModel(
                show.getId(),
                show.getMovie().getTitle(),
                show.getMovie().getLengthMinutes(),
                show.getMovie().getDescription(),
                show.getAudioLanguage().getCode(),
                show.getSubtitlesLanguage() == null ? null : show.getSubtitlesLanguage().getCode(),
                show.getStartTime());
    }
}
