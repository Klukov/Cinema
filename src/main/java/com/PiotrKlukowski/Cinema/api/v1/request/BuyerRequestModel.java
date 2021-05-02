package com.PiotrKlukowski.Cinema.api.v1.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class BuyerRequestModel {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
}
