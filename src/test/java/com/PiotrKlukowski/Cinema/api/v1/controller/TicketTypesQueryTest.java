package com.PiotrKlukowski.Cinema.api.v1.controller;

import com.PiotrKlukowski.Cinema.CinemaApplication;
import com.PiotrKlukowski.Cinema.api.v1.response.TicketTypeResponseModel;
import com.PiotrKlukowski.Cinema.repository.CinemaRepository;
import com.PiotrKlukowski.Cinema.repository.RoomRepository;
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

import java.math.BigDecimal;
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
public class TicketTypesQueryTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CinemaRepository cinemaRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void shouldReturnAllTicketTypes() throws Exception {
        // when
        var httpResult = mvc.perform(get("/cinema/api/v1/ticket-types"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();
        var result = objectMapper.readValue(httpResult.getContentAsByteArray(), TicketTypeResponseModel[].class);

        // then
        Assertions.assertEquals(3, result.length);
        Assertions.assertTrue(correctResponse().containsAll(Arrays.asList(result)));
    }

    private static List<TicketTypeResponseModel> correctResponse() {
        var correctResponse = new ArrayList<TicketTypeResponseModel>();
        correctResponse.add(
                new TicketTypeResponseModel(
                        "NORMAL",
                        new BigDecimal("40.00"),
                        new BigDecimal("10.00"),
                        new BigDecimal("15.00")));
        correctResponse.add(
                new TicketTypeResponseModel(
                        "STUDENT",
                        new BigDecimal("30.00"),
                        new BigDecimal("8.00"),
                        new BigDecimal("12.00")));
        correctResponse.add(
                new TicketTypeResponseModel(
                        "PENSIONER",
                        new BigDecimal("20.00"),
                        new BigDecimal("5.00"),
                        new BigDecimal("7.50")));
        return correctResponse;
    }
}
