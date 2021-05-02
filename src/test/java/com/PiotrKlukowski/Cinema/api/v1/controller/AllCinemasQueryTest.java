package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.CinemaApplication;
import com.PiotrKlukowski.Cinema.api.v1.response.CinemaResponseModel;
import com.PiotrKlukowski.Cinema.repository.CinemaRepository;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CinemaApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class AllCinemasQueryTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Test
    public void shouldReturnAllCinemas() throws Exception {
        // when
        var httpResult = mvc.perform(get("/cinema/api/v1/cinemas"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        var result = objectMapper.readValue(httpResult.getContentAsByteArray(), CinemaResponseModel[].class);

        // then
        Assertions.assertEquals(3, result.length);
        Assertions.assertTrue(expectedResponse().containsAll(Arrays.asList(result)));
    }

    private static List<CinemaResponseModel> expectedResponse() {
        var expectedResult = new ArrayList<CinemaResponseModel>();
        expectedResult.add(
                new CinemaResponseModel(
                        1,
                        "Warszawskie kino",
                        "Warszawa",
                        "00-000",
                        "Galeria Polnocna",
                        "123456789",
                        "kinoWarszawa@kino.pl"
                ));
        expectedResult.add(
                new CinemaResponseModel(
                        2,
                        "Suwalskie kino",
                        "Suwalki",
                        "16-400",
                        "Plaza",
                        "987654321",
                        "kinoSuwalki@kino.pl"
                ));
        expectedResult.add(
                new CinemaResponseModel(
                        3,
                        "Dupa a nie kino",
                        "Grudziadz",
                        "00-010",
                        "Wypizdow",
                        "111222333",
                        "kinoWypizdow@kino.pl"
                ));
        return expectedResult;
    }
}
