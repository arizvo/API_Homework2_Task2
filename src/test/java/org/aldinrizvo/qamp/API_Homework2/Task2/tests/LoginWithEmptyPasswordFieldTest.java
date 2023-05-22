package org.aldinrizvo.qamp.API_Homework2.Task2.tests;

import io.restassured.response.Response;
import org.aldinrizvo.qamp.API_Homework2.Task2.steps.HttpRequests;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.AuthenticationRequest;
import org.aldinrizvo.qamp.API_Homework2.Task2.utils.GlobalValues;
import org.testng.annotations.Test;

public class LoginWithEmptyPasswordFieldTest {

    @Test(
            priority = 1,
            description = "This tests verifies that user can't sign in with invalid email."
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
