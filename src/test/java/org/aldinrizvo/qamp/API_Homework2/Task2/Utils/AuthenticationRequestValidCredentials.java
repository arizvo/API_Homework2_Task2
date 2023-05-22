package org.aldinrizvo.qamp.API_Homework2.Task2.Utils;

import org.assertj.core.api.Assertions;

import java.util.Map;

public class AuthenticationRequestValidCredentials {
    private final Map<String, String> authParams;

    public AuthenticationRequestValidCredentials(final String email, final String password) {
        authParams = Map.of("email", email, "password", password);
    }

    public void validateResponseHeaders(final String contentType) {
        Assertions.assertThat(contentType)
                .as("Wrong JSON response Content-Type header!")
                .isEqualTo(GlobalValues.APPLICATION_JSON);
    }

    public void validateResponseStatusCode(final int statusCode) {
        Assertions.assertThat(statusCode)
                .as("Invalid status code!")
                .isEqualTo(201);
    }

    public Map<String, String> getAuthParams() {
        return authParams;
    }
}
