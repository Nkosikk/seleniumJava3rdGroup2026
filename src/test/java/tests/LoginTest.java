package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.LoginPayload;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseTest {

    @Test
    @Owner("Nosisa")
    @Description("Verify successful login and retrieve authentication token")
    public void loginTest() {

        // Create login request body
        LoginPayload payload = new LoginPayload(EMAIL, PASSWORD);

        // Send login request
        Response response =
                given()
                        .log().all()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(payload)
                        .when()
                        .post(Endpoints.LOGIN);

        response.then().log().all();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Store Bearer Token
        authToken = response.jsonPath().getString("data.token");

        // Verify token is returned
        Assert.assertNotNull(authToken);

        System.out.println("Bearer Token:");
        System.out.println(authToken);

        
    }

}