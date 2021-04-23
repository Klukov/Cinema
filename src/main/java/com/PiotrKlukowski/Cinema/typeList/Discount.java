package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Discount {
    KEBAB("PALIDUPE", new BigDecimal("0.3")),
    MOTOINTEGRATOR("MOTOINTEGRATOR", new BigDecimal("0.5"));

    @Getter
    private final String code;

    @Getter
    private final BigDecimal discountFactor;

    Discount(String code, BigDecimal discountFactor) {
        this.code = code;
        this.discountFactor = discountFactor;
    }

    public static Discount getDiscountFromCode(String code) throws EnumIncorrectnessException {
        if (code == null) {return null;}
        return Arrays.stream(Discount.values()).filter(discount ->
                discount.getCode().equals(code)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect language code"));
    }
}
