package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;

import java.util.Arrays;

public enum AudioType {
    ORIGINAL,
    DUBBING,
    LECTOR;

    public static AudioType getAudioTypeFromName(String name) {
        if (name == null) {return null;}
        return Arrays.stream(AudioType.values()).filter(discount ->
                discount.name().equals(name)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect audio type"));
    }
}
