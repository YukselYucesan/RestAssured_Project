import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class _16_SerchForKeywords {
    @Test
    public void testSearchForKeywords() {

        RestAssured.baseURI = "https://api.themoviedb.org/3";

        String apiKey = "1975cd41d7a516c194361589197b21a6";
        String searchQuery = "space";

        Response response = given()
                .queryParam("api_key", apiKey)
                .queryParam("query", searchQuery)
                .when()
                .get("/search/keyword")
                .then()
                .statusCode(200)
                .body("results", not(empty()))
                .body("results[0].name", containsStringIgnoringCase(searchQuery))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
