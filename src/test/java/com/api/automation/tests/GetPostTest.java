
package com.api.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetPostTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void verifyGetPostById() {

        given()
            .pathParam("id", 1)
        .when()
            .get("/posts/{id}")
        .then()
            .statusCode(200)
            .body("id", equalTo(1))
            .body("userId", equalTo(1));
    }


@Test
public void verifyGetAllPosts() {

    ApiHelper.getRequest("/posts")
        .then()
        .statusCode(200)
        .body("size()", equalTo(100));
}



@Test
public void verifyCreatePost() {

    String requestBody = "{"
            + "\"title\":\"API Testing\","
            + "\"body\":\"Learning Rest Assured\","
            + "\"userId\":1"
            + "}";

    ApiHelper.postRequest("/posts", requestBody)
        .then()
        .statusCode(201)
        .body("title", equalTo("API Testing"))
        .body("userId", equalTo(1));
}


    @Test
    public void verifyGetInvalidPost() {

        given()
            .pathParam("id", 9999)
        .when()
            .get("/posts/{id}")
        .then()
            .statusCode(404);
    }
}
