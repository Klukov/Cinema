package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;

import java.util.Arrays;

public enum MovieStatus {
    AVAILABLE,
    ARCHIVED;

    public static MovieStatus getMovieStatusFromCode(String code) throws EnumIncorrectnessException {
        return Arrays.stream(MovieStatus.values()).filter(roomType ->
                roomType.name().equals(code)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect movie status code"));
    }
}
