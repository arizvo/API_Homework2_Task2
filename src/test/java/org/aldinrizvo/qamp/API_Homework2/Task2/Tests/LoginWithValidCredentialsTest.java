package org.aldinrizvo.qamp.API_Homework2.Task2.Tests;

import io.restassured.response.Response;
import org.aldinrizvo.qamp.API_Homework2.Task2.Steps.HttpRequests;
import org.aldinrizvo.qamp.API_Homework2.Task2.Utils.AuthenticationRequestValidCredentials;
import org.aldinrizvo.qamp.API_Homework2.Task2.Utils.GlobalValues;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginWithValidCredentialsTest {
    private static final Logger LOGGER = Logger.getLogger(LoginWithValidCredentialsTest.class.getName());

    @Test(priority = 1, description = "This Tests verifies that user is able to log in to PlaceLab")
    public void testLoginPagePositive() {
        final AuthenticationRequestValidCredentials authenticationRequest = new AuthenticationRequestValidCredentials(GlobalValues.EMAIL, GlobalValues.PASSWORD);

        final Response response = HttpRequests.sendWwwFormUrlEncodedPostRequest(
                "api/v2/sessions",
                authenticationRequest.getAuthParams()
        );
        LOGGER.info("Submit authentication POST request!");

        authenticationRequest.validateResponseHeaders(response.contentType());
        authenticationRequest.validateResponseStatusCode(response.statusCode());
    }
}
