package com.PiotrKlukowski.Cinema.utils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class PictureUtils {
    public byte[] convertPictureFromFile(String resourceFilePath) throws IOException {
        File file = new File(getClass().getClassLoader().getResource(resourceFilePath).getFile());
        return Files.readAllBytes(file.toPath());
    }

    public static void main(String[] args) {
        PictureUtils pictureUtils = new PictureUtils();
        byte[] test;
        try {
             test = pictureUtils.convertPictureFromFile("moviesPictures/StarWars2.jpg");
             FileOutputStream fileOutputStream = new FileOutputStream("test.jpg");
             fileOutputStream.write(test);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
