package com.PiotrKlukowski.Cinema.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonWriter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("cannot create json string");
            return "";
        }
    }
}
