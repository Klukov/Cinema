package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.CinemaApplication;
import com.PiotrKlukowski.Cinema.api.v1.response.MovieResponseModel;
import com.PiotrKlukowski.Cinema.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CinemaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class AllMoviesQueryTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void shouldReturnAllAvailableMovies() throws Exception {
        // when
        var httpResult = mvc.perform(get("/cinema/api/v1/movies"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        var result = objectMapper.readValue(httpResult.getContentAsByteArray(), MovieResponseModel[].class);

        // then
        Assertions.assertEquals(6, result.length);
        Assertions.assertEquals(9, movieRepository.findAll().size());
    }
}
