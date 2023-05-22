package org.aldinrizvo.qamp.API_Homework2.Task2.utils;

import org.assertj.core.api.Assertions;

import java.util.Map;

public class AuthenticationRequest {
    private final Map<String, String> authParams;

    public AuthenticationRequest(final String email, final String password) {
        authParams = Map.of("email", email, "password", password);
    }

    public void validateResponseHeaders(final String contentType) {
        Assertions.assertThat(contentType)
                .as("Wrong JSON response Content-Type header!")
                .isEqualTo(GlobalValues.APPLICATION_JSON);
    }

    public void validateResponseStatusCode(final int statusCode, final boolean expectSuccess) {
        final int expectedStatusCode;

        if (expectSuccess) {
            expectedStatusCode = 201;
        } else {
            expectedStatusCode = 401;

        }
        Assertions.assertThat(statusCode)
                .as("Invalid status code!")
                .isEqualTo(expectedStatusCode);
    }

    public Map<String, String> getAuthParams() {
        return authParams;
    }
}
