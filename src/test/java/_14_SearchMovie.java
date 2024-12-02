import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class _14_SearchMovie {

    @Test
    public void testSearchForMovies() {

        RestAssured.baseURI = "https://api.themoviedb.org/3";

        String apiKey = "1975cd41d7a516c194361589197b21a6";

        String searchQuery = "Inception";

        Response response = given()
                .queryParam("api_key", apiKey)
                .queryParam("query", searchQuery)
                .when()
                .get("/search/movie")
                .then()
                .statusCode(200)
                .body("results", not(empty()))
                .body("results[0].title", containsStringIgnoringCase(searchQuery))
                .extract().response();
        System.out.println("Response: " + response.asString());
    }
}
