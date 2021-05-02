package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.api.v1.response.MovieResponseModel;
import com.PiotrKlukowski.Cinema.api.v1.service.ShowService;
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
        return showService.findAllMovies(MovieStatus.AVAILABLE);
    }
}
