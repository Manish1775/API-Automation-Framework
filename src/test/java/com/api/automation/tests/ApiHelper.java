
package com.api.automation.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    static {
        RestAssured.baseURI =
                "https://jsonplaceholder.typicode.com";
    }

    public static Response getRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint);
    }

public static Response postRequest(String endpoint, Object requestBody) {
    return given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .post(endpoint);
}

public static Response putRequest(String endpoint, Object requestBody) {
    return given()
            .contentType("application/json")
            .body(requestBody)
            .when()
            .put(endpoint);
}

public static Response deleteRequest(String endpoint) {
    return given()
            .when()
            .delete(endpoint);
}


}
