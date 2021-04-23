package com.PiotrKlukowski.Cinema.api.v1.service.controller.cinema

import com.PiotrKlukowski.Cinema.api.v1.controller.CinemaController
import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@WebMvcTest(CinemaController.class)
@ActiveProfiles("test")
class TicketTypesQueryTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    private ObjectMapper objectMapper

    def "should return all ticket types with prices"() {
        when:
        def httpResult = mvc.perform(get("/cinema/api/v1/ticket-types"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
        def result = objectMapper.readValue(httpResult.getContentAsByteArray(), TicketTypeResponseModel[].class)

        then:
        result.size() == 3
    }
}
