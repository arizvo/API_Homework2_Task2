package org.aldinrizvo.qamp.API_Homework2.Task2.Tests;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.aldinrizvo.qamp.API_Homework2.Task2.steps.HttpRequests;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.AuthenticationRequest;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.GlobalValues;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginWithInvalidPasswordTest {
    private static final Logger LOGGER = Logger.getLogger(LoginWithInvalidPasswordTest.class.getName());

    @Test(
            priority = 1,
            description = "This Tests verifies that user can't sign in with invalid email."
    )
    public void testLoginPageNegative() {
        final Faker faker = new Faker();
        final AuthenticationRequest authenticationRequest =
                new AuthenticationRequest(GlobalValues.EMAIL, faker.internet().password());

        final Response response = HttpRequests.sendWwwFormUrlEncodedPostRequest(
                GlobalValues.AUTH,
                authenticationRequest.getAuthParams()
        );

        authenticationRequest.validateResponseHeaders(response.contentType());
        authenticationRequest.validateResponseStatusCode(response.statusCode(), false);
    }
}
