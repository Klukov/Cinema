package com.PiotrKlukowski.Cinema.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SeatResponseModel {
    private final String id;
    private final Integer row;
    private final Integer column;
    private final String seatType;
    private final String seatStatus;
}
