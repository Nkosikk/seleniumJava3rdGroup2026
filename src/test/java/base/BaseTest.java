package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.LoginPayload;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected static final String BASE_URL = "https://www.ndosiautomation.co.za/APIDEV";

    // Authentication token
    public static String authToken;

    // Announcement ID used for request chaining
    public static String announcementId;

    // Login credentials
    public static final String EMAIL = "yolandamasiza@gmail.com";
    public static final String PASSWORD = "Masiza@1988";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }

    protected void login() {

        LoginPayload payload = new LoginPayload(EMAIL, PASSWORD);

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .when()
                        .post(Endpoints.LOGIN);

        authToken = response.jsonPath().getString("data.token");
    }
}