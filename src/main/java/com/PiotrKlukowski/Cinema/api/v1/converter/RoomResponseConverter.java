package com.PiotrKlukowski.Cinema.api.v1.converter;

import com.PiotrKlukowski.Cinema.api.v1.response.RoomResponseModel;
import com.PiotrKlukowski.Cinema.model.Room;

public class RoomResponseConverter {

    public static RoomResponseModel convert(Room room) {
        return new RoomResponseModel(room.getId(), room.getRoomInCinemaNumber());
    }
}
