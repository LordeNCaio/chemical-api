package com.chemicalgears.chemicalapi.security;

import com.chemicalgears.chemicalapi.utils.LocalDateTimeHelpers;

import java.time.LocalDateTime;
import java.util.Date;

public class SecurityConstants {
    public static final String SECRET = "095922CBE85E733AB95C2AE16FC86FD8C06FEE4A0EF573714D21419678BECD87";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
    public static Date EXPIRATION_TIME() {
        LocalDateTime localDateTime = LocalDateTime.now().plusHours(2);
        return LocalDateTimeHelpers.toDate(localDateTime);
    };

    public static final String SIGNUP_URL = "/users/signup";
    public static final String SIGNIN_URL = "/users/signin";
}
