package com.PiotrKlukowski.Cinema.typeList;

import com.PiotrKlukowski.Cinema.exception.EnumIncorrectnessException;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Arrays;

public enum Discount {
    KEBAB("PALIDUPE", new BigDecimal("0.3")),
    MOTOINTEGRATOR("MOTOINTEGRATOR", new BigDecimal("0.5"));

    @Getter
    private String code;

    @Getter
    private BigDecimal discountFactor;

    Discount(String code, BigDecimal discountFactor) {
        this.code = code;
        this.discountFactor = discountFactor;
    }

    public static Discount getDiscountFromCode(String code) throws EnumIncorrectnessException {
        return Arrays.stream(Discount.values()).filter(discount ->
                discount.getCode().equals(code)).findFirst()
                .orElseThrow(() -> new EnumIncorrectnessException("Incorrect language code"));
    }
}
