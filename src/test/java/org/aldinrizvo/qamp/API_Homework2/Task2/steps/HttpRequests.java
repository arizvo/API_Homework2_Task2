package org.aldinrizvo.qamp.API_Homework2.Task2.steps;

import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.aldinrizvo.qamp.API_Homework2.Task2.utils.GlobalValues.HOST;

public class HttpRequests {
    public static <T> Response sendWwwFormUrlEncodedPostRequest(final String endpoint, final Map<String, T> params) {
        return given()
                .contentType("application/x-www-form-urlencoded")
                .baseUri(HOST)
                .formParams(params)
                .post(endpoint);
    }
}
