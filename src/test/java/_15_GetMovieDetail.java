import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class _15_GetMovieDetail {
    @Test
    public void testGetMovieDetails() {

        RestAssured.baseURI = "https://api.themoviedb.org/3";
        String apiKey = "1975cd41d7a516c194361589197b21a6";

        int movieId = 27205; // Inception movie ID

        Response response = given()
                .queryParam("api_key", apiKey)
                .pathParam("movie_id", movieId)
                .when()
                .get("/movie/{movie_id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(movieId))
                .body("title", not(emptyOrNullString()))
                .extract().response();
        System.out.println("Response: " + response.asString());
    }
}
