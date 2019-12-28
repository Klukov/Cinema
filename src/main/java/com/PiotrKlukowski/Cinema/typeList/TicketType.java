package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;

import java.math.BigDecimal;
import java.util.Arrays;

public enum TicketType {
    NORMAL(new BigDecimal("40.00"), new BigDecimal("10.00"), new BigDecimal("15.00")),
    STUDENT(new BigDecimal("40.00"), new BigDecimal("10.00"), new BigDecimal("15.00")),
    PENSIONER(new BigDecimal("40.00"), new BigDecimal("10.00"), new BigDecimal("15.00"));


    private BigDecimal pricePLN;
    private BigDecimal priceEUR;
    private BigDecimal priceUSD;

    TicketType(BigDecimal pricePLN, BigDecimal priceEUR, BigDecimal priceUSD) {
        this.pricePLN = pricePLN;
        this.priceEUR = priceEUR;
        this.priceUSD = priceUSD;
    }

    public BigDecimal getPriceByCurrency(Currency currency) {
        if (currency == Currency.PLN) {
            return pricePLN;
        } else if (currency == Currency.EUR) {
            return priceEUR;
        } else if (currency == Currency.USD) {
            return priceUSD;
        }
        throw new EnumIncorrectnessException("Currency doesn't have corresponding price: " + currency.name());
    }

    public static TicketType getTicketTypeFromName(String name) throws EnumIncorrectnessException {
        String convertedName = name.toUpperCase();
        return Arrays.stream(TicketType.values()).filter(ticketType ->
                ticketType.name().equals(convertedName)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect ticket type name"));
    }
}
