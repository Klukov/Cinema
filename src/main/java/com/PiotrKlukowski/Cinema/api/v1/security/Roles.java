package com.PiotrKlukowski.Cinema.api.v1.security;

import org.springframework.stereotype.Component;

@Component
public class Roles {

    public final String OWNER_ADMIN = "ROLE_OWNER_ADMIN";
    public final String CINEMA_ADMIN = "ROLE_CINEMA_ADMIN";
    public final String ADMIN = "ROLE_ADMIN";
}
