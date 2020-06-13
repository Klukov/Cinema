package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;

import java.util.Arrays;

public enum SeatType {
    NORMAL,
    VIP,
    NOT_EXIST;

    public static SeatType getSeatTypeFromName(String name) {
        if (name == null) {return null;}
        return Arrays.stream(SeatType.values()).filter(discount ->
                discount.name().equals(name)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect seat type"));
    }
}
