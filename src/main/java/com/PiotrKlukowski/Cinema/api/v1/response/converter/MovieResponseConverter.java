package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.MovieResponseModel;
import com.PiotrKlukowski.Cinema.model.Movie;

public class MovieResponseConverter {

    public static MovieResponseModel convert(Movie movie) {
        return new MovieResponseModel(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getLengthMinutes());
    }
}
