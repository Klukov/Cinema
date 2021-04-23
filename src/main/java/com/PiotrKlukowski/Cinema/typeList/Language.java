package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;
import lombok.Getter;

import java.util.Arrays;

public enum Language {
    ENGLISH("ENG"),
    POLISH("PL"),
    GERMAN( "GER");

    @Getter
    private final String code;

    Language(String code) {
        this.code = code;
    }

    public static Language getLanguageFromCode(String code) throws EnumIncorrectnessException {
        if (code == null) {return null;}
        return Arrays.stream(Language.values()).filter(language ->
                language.getCode().equals(code)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect language code"));
    }
}
