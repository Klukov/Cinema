package com.PiotrKlukowski.Cinema.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public final class PictureUtils {

    //TODO: make it static
    public byte[] convertPictureFromFile(String resourceFilePath) throws IOException {
        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource(resourceFilePath)).getFile());
        return Files.readAllBytes(file.toPath());
    }
}
