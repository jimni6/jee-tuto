import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.equalTo;

public class LoginServletFunctionalTest {

    @BeforeAll
    public static void setUp() {
        // Assuming the application is running on localhost:8080
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/jeeTuto_war_exploded";
        // Initialize the embedded server and deploy the application
        // For example, using an embedded Tomcat or Jetty server
    }

    @Test
    public void testLoginSuccess() {
        // Simulate a POST request to the login endpoint
        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("txtLogin", "john.doe@example.com")
                .formParam("txtPassword", "password")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response();

        // Verify the response and the resulting state
        String redirectedUrl = response.getHeader("Location");
        assertEquals("/viewProduct.jsp", redirectedUrl);

        // Additional assertions to verify session and attributes can be done
    }

    @Test
    public void testLoginFailure() {
        // Simulate a POST request with invalid credentials
        given()
                .contentType(ContentType.URLENC)
                .formParam("txtLogin", "invalidUser")
                .formParam("txtPassword", "wrongPassword")
                .when()
                .post("/login")
                .then()
                .statusCode(200)  // Assuming a 200 OK status code, change as appropriate
                .body("errorMessage", equalTo("Email ou mot de passe incorrect."));
    }
}
