package com.PiotrKlukowski.Cinema.api.v1.service

import com.PiotrKlukowski.Cinema.api.v1.response.model.TicketTypeResponseModel
import spock.lang.Specification
import spock.lang.Subject

class AllCinemasQueryTest extends Specification {

    @Subject
    TicketTypesQuery sub = new CinemaService(null, null)

    def "find all ticket types"() {
        when:
        def result = sub.getAllTicketTypes()

        then:
        result.toSet() == correctResponse().toSet()
    }

    static List<TicketTypeResponseModel> correctResponse() {
        [
                new TicketTypeResponseModel(
                        "NORMAL",
                        new BigDecimal("40.00"),
                        new BigDecimal("10.00"),
                        new BigDecimal("15.00"),
                ),
                new TicketTypeResponseModel(
                        "STUDENT",
                        new BigDecimal("30.00"),
                        new BigDecimal("8.00"),
                        new BigDecimal("12.00"),
                ),
                new TicketTypeResponseModel(
                        "PENSIONER",
                        new BigDecimal("20.00"),
                        new BigDecimal("5.00"),
                        new BigDecimal("7.50"),
                ),
        ]
    }
}
