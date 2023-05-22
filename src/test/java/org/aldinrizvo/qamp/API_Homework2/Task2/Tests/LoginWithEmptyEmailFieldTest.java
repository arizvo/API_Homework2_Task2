package org.aldinrizvo.qamp.API_Homework2.Task2.Tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.aldinrizvo.qamp.API_Homework2.Task2.Steps.HttpRequests;
import org.aldinrizvo.qamp.API_Homework2.Task2.Utils.AuthenticationRequestInvalidCredentilas;
import org.aldinrizvo.qamp.API_Homework2.Task2.Utils.GlobalValues;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginWithEmptyEmailFieldTest {
    private static final Logger LOGGER = Logger.getLogger(LoginWithInvalidEmailTest.class.getName());

    @Test(
            priority = 1,
            description = "This Tests verifies that user can't sign in with invalid email, and receives error message."
    )
    public void testLoginPageNegative() {
        Faker faker = new Faker();
        final AuthenticationRequestInvalidCredentilas authenticationRequest =
                new AuthenticationRequestInvalidCredentilas("", GlobalValues.PASSWORD);

        final Response response = HttpRequests.sendWwwFormUrlEncodedPostRequest(
                "api/v2/sessions",
                authenticationRequest.getAuthParams()
        );
        LOGGER.info("Submit authentication POST request!");

        authenticationRequest.validateResponseHeaders(response.contentType());
        authenticationRequest.validateResponseStatusCode(response.statusCode());
    }
}
