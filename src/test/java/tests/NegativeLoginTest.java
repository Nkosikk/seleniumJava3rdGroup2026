package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.LoginPayload;

import static io.restassured.RestAssured.given;

public class NegativeLoginTest {

    @Test
    @Owner("Nosisa")
    @Description("Verify login fails with invalid credentials")
    public void invalidLogin() {

        LoginPayload payload = new LoginPayload(
                "yolandamasiza@gmail.com",
                "WrongPassword123"
        );

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .when()
                        .post("https://www.ndosiautomation.co.za/APIDEV/login")
                        .then()
                        .extract()
                        .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 401);
    }
}