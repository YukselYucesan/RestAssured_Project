import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _17_AddMovieRating {
    @Test
    public void testAddMovieRating() {
        RestAssured.baseURI = "https://api.themoviedb.org/3";

        String apiKey = "1975cd41d7a516c194361589197b21a6";
        String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxOTc1Y2Q0MWQ3YTUxNmMxOTQzNjE1ODkxOTdiMjFhNiIsIm5iZiI6MTczMjA4OTM4OC45OCwic3ViIjoiNjczZDk2MmM4ZTM1N2EyZGVkOTU4NTllIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.YbbyukT8g7E_INqS_2P5ItPOuQ31mn8jZhEcQ--o2AE"; // Bearer Token

        int movieId = 27205; // Example: Inception movie ID
        double rating = 8.5; // Rating between 0.5 and 10

        Response response = given()
                .header("Authorization", "Bearer " + bearerToken)
                .header("Content-Type", "application/json;charset=utf-8")
                .queryParam("api_key", apiKey)
                .pathParam("movie_id", movieId)
                .body("{ \"value\": " + rating + " }")
                .when()
                .post("/movie/{movie_id}/rating")
                .then()
                .statusCode(201)
                .body("status_code", equalTo(1))
                .body("status_message", equalTo("Success."))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
