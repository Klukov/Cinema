package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;
import lombok.Getter;

import java.util.Arrays;

public enum RoomType {

    NORMAL("2D","Only typical 2D films"),
    SPECIAL_3D("3D", "2D and 3D films possible to watch"),
    SPECIAL_4DX("4DX", "2D and 3D possible, but special seats are there");

    @Getter
    private String code;

    @Getter
    private String description;

    RoomType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static RoomType getRoomTypeFromCode(String code) throws EnumIncorrectnessException {
        return Arrays.stream(RoomType.values()).filter(roomType ->
                roomType.getCode().equals(code)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect room type code"));
    }
}
