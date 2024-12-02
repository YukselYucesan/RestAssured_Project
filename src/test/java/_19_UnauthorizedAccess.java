import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _19_UnauthorizedAccess {
    @Test
    public void testUnauthorizedAccess() {

        RestAssured.baseURI = "https://api.themoviedb.org/3";

        int validListId = 123456; // Example list ID
        String requestBody = "{ \"media_id\": 18 }";
        String invalidSessionId = "invalid_session_id";

        Response response = given()
                .queryParam("session_id", invalidSessionId)
                .pathParam("list_id", validListId)
                .header("Content-Type", "application/json;charset=utf-8")
                .body(requestBody)
                .when()
                .post("/list/{list_id}/add_item")
                .then()
                .statusCode(401)
                .body("status_code", equalTo(7))
                .body("status_message", equalTo("Authentication failed: You do not have permissions to access the service."))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
