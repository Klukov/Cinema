package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.response.model.MovieResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.service.ShowService;
import com.PiotrKlukowski.Cinema.exception.ExceptionDecorator;
import com.PiotrKlukowski.Cinema.typeList.MovieStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path="cinema/api/v1/", produces="application/json")
public class MovieController {

    private final ShowService showService;

    public MovieController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("movies")
    public Set<MovieResponseModel> getAllMovies() {
        return ExceptionDecorator.wrap(() -> showService.findAllMovies(MovieStatus.AVAILABLE));
    }
}
