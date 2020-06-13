package com.PiotrKlukowski.Cinema.api.v1.request.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
public class BuyerRequestModel {

    @Getter
    private String firstName;

    @Getter
    private String secondName;

    @Getter
    private String lastName;

    @Getter
    private String email;

    @Getter
    private String phoneNumber;
}
