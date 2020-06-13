package com.PiotrKlukowski.Cinema.api.v1.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RoomResponseModel {

    @Getter
    private Integer id;

    @Getter
    private String roomNumber;
}
