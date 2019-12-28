package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SeatResponseModel {

    @Getter
    private String id;

    @Getter
    private Integer row;

    @Getter
    private Integer column;

    @Getter
    private String seatType;

    @Getter
    private String seatStatus;
}
