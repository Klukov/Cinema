package com.PiotrKlukowski.Cinema.dataLoader;

import com.PiotrKlukowski.Cinema.repository.MovieRepository;
import com.PiotrKlukowski.Cinema.utils.PictureUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Order(value = 1)
@Component
@ConditionalOnProperty(name = "app.initial-db-load", havingValue = "true")
@Slf4j
public class PicturesDataLoader implements CommandLineRunner {

    private static final Map<String, String> MOVIE_TITLE_TO_PICTURE_NAME = new HashMap<>() {{
        put("Star Wars Phantom Menace", "moviesPictures/StarWars1.jpg");
        put("Star Wars Attack of the Clones", "moviesPictures/StarWars2.jpg");
        put("Star Wars Revenge of the Sith", "moviesPictures/StarWars3.jpg");
        put("Lord of The Rings The Fellowship of the Ring", "moviesPictures/LordOfTheRings1.jpg");
        put("Lord of The Rings The Two Towers", "moviesPictures/LordOfTheRings2.jpg");
        put("Lord of The Rings The return of the king", "moviesPictures/LordOfTheRings3.jpg");
    }};

    private MovieRepository movieRepository;

    public PicturesDataLoader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadPicturesForAllMovies();
    }

    @Transactional
    void loadPicturesForAllMovies() {
        movieRepository.findAll().forEach(movie -> {
            String title = movie.getTitle();
            if (MOVIE_TITLE_TO_PICTURE_NAME.containsKey(title)) {
                try {
                    byte[] picture = new PictureUtils().convertPictureFromFile(MOVIE_TITLE_TO_PICTURE_NAME.get(title));
                    movie.setPicture(picture);
                    movieRepository.save(movie);
                } catch (IOException e) {
                    log.debug("Cannot save picture for movie: " + title);
                    e.printStackTrace();
                }
            }
        });
    }
}
