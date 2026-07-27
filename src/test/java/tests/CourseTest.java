package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class CourseTest extends BaseTest {

    @BeforeMethod
    public void authenticate() {
        login();
    }

    @Test
    @Owner("Nosisa")
    @Description("Verify published beginner automation courses are retrieved successfully")
    public void getPublishedCourses() {
        Response response =
                given()
                        .header("Authorization", "Bearer " + authToken)
                        .queryParam("category", "automation")
                        .queryParam("level", "beginner")
                        .queryParam("search", "")
                        .when()
                        .get(Endpoints.COURSES)
                        .then()
                        .extract()
                        .response();

        // Print response
        System.out.println(response.asPrettyString());

        // Verify status code
        Assert.assertEquals(response.getStatusCode(), 200);

        // Verify success
        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        // Verify message
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Courses retrieved successfully"
        );

        // Verify at least one course exists
        Assert.assertTrue(
                response.jsonPath().getList("data.courses").size() > 0
        );

        // Verify first course level
        Assert.assertEquals(
                response.jsonPath().getString("data.courses[0].Level"),
                "beginner"
        );

        // Verify first course category
        Assert.assertEquals(
                response.jsonPath().getString("data.courses[0].Category"),
                "automation"
        );

        System.out.println("Course Test Passed");
    }

   }