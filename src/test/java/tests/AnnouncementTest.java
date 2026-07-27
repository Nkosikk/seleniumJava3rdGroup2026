package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.AnnouncementPayload;
import utils.Endpoints;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;

public class AnnouncementTest extends BaseTest {

    @BeforeMethod
    public void authenticate() {
        login();
    }

    @Test
    @Owner("Nosisa")
    @Description("Create a new announcement")
    public void createAnnouncement() {

        AnnouncementPayload payload = new AnnouncementPayload(
                "Important Update",
                "This is the announcement content"
        );

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + authToken)
                        .body(payload)
                        .when()
                        .post(Endpoints.ANNOUNCEMENTS)
                        .then()
                        .extract()
                        .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));
        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Announcement created successfully"
        );

        // Save ID for request chaining
        announcementId = response.jsonPath().getString("data.id");

        Assert.assertNotNull(announcementId);

        System.out.println("Announcement ID: " + announcementId);
    }

    @Test(dependsOnMethods = "createAnnouncement")
    @Owner("Nosisa")
    @Description("Get all announcements")
    public void getAnnouncements() {

        Response response =
                given()
                        .header("Authorization", "Bearer " + authToken)
                        .when()
                        .get(Endpoints.ANNOUNCEMENTS)
                        .then()
                        .extract()
                        .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Announcements retrieved successfully"
        );

        Assert.assertTrue(
                response.jsonPath().getList("data.announcements").size() > 0
        );

        System.out.println("Get Announcements Passed");
    }

    @Test(dependsOnMethods = "getAnnouncements")
    @Owner("Nosisa")
    @Description("Update announcement")
    public void updateAnnouncement() {

        AnnouncementPayload payload = new AnnouncementPayload(
                "Updated Title",
                "Announcement changes"
        );

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + authToken)
                        .body(payload)
                        .when()
                        .put(Endpoints.ANNOUNCEMENTS + "/" + announcementId)
                        .then()
                        .extract()
                        .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Announcement updated successfully"
        );

        System.out.println("Update Announcement Passed");
    }

    @Test(dependsOnMethods = "updateAnnouncement")
    @Owner("Nosisa")
    @Description("Delete announcement")
    public void deleteAnnouncement() {

        Response response =
                given()
                        .header("Authorization", "Bearer " + authToken)
                        .when()
                        .delete(Endpoints.ANNOUNCEMENTS + "/" + announcementId)
                        .then()
                        .extract()
                        .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getBoolean("success"));

        Assert.assertEquals(
                response.jsonPath().getString("message"),
                "Announcement deleted successfully"
        );

        System.out.println("Delete Announcement Passed");
    }

    @Test
    @Owner("Nosisa")
    @Description("Verify update fails for an invalid announcement ID")
    public void updateInvalidAnnouncement() {

        AnnouncementPayload payload =
                new AnnouncementPayload(
                        "Updated Title",
                        "Updated Content"
                );

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer " + authToken)
                        .body(payload)
                        .when()
                        .put(Endpoints.ANNOUNCEMENTS + "/invalid-id")
                        .then()
                        .extract()
                        .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 400);
    }

    @Test
    @Owner("Nosisa")
    @Description("Verify delete fails for an invalid announcement ID")
    public void deleteInvalidAnnouncement() {

        //System.out.println(authToken);

        Response response =
                given()
                        .header("Authorization", "Bearer " + authToken)
                        .when()
                        .delete(Endpoints.ANNOUNCEMENTS + "/invalid-id")
                        .then()
                        .extract()
                        .response();

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 400);
    }
}