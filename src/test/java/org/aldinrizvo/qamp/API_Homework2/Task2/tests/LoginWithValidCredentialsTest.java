package org.aldinrizvo.qamp.API_Homework2.Task2.tests;

import io.restassured.response.Response;
import org.aldinrizvo.qamp.API_Homework2.Task2.steps.HttpRequests;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.AuthenticationRequest;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.GlobalValues;
import org.testng.annotations.Test;

public class LoginWithValidCredentialsTest {

    @Test(priority = 1, description = "This tests verifies that user is able to log in to PlaceLab")
    public void testLoginPagePositive() {
        final AuthenticationRequest authenticationRequest = new AuthenticationRequest(
                GlobalValues.EMAIL,
                GlobalValues.PASSWORD
                );

        final Response response = HttpRequests.sendWwwFormUrlEncodedPostRequest(
                GlobalValues.AUTH,
                authenticationRequest.getAuthParams()
        );

        authenticationRequest.validateResponseHeaders(response.contentType());
        authenticationRequest.validateResponseStatusCode(response.statusCode(), true);
    }
}
