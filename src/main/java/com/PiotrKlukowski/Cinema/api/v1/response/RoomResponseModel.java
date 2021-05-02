package com.PiotrKlukowski.Cinema.api.v1.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoomResponseModel {
    private final Integer id;
    private final String roomNumber;
}
