package org.aldinrizvo.qamp.API_Homework2.Task2.Tests;

import io.restassured.response.Response;
import org.aldinrizvo.qamp.API_Homework2.Task2.steps.HttpRequests;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.AuthenticationRequest;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.GlobalValues;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class LoginWithEmptyPasswordFieldTest {
    private static final Logger LOGGER = Logger.getLogger(LoginWithEmptyPasswordFieldTest.class.getName());

    @Test(
            priority = 1,
            description = "This Tests verifies that user can't sign in with invalid email."
    )
    public void testLoginPageNegative() {
        final AuthenticationRequest authenticationRequest =
                new AuthenticationRequest(GlobalValues.EMAIL, "");

        final Response response = HttpRequests.sendWwwFormUrlEncodedPostRequest(
                GlobalValues.AUTH,
                authenticationRequest.getAuthParams()
        );

        authenticationRequest.validateResponseHeaders(response.contentType());
        authenticationRequest.validateResponseStatusCode(response.statusCode(), false);
    }
}
