package com.PiotrKlukowski.Cinema.api.v1.response.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.model.RoomResponseModel;
import com.PiotrKlukowski.Cinema.model.Room;

public class RoomResponseConverter {

    public static RoomResponseModel convert(Room room) {
        return new RoomResponseModel(room.getId(), room.getRoomInCinemaNumber());
    }
}
