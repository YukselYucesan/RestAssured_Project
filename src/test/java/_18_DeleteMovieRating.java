import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class _18_DeleteMovieRating {
    @Test
    public void testDeleteMovieRating() {

        RestAssured.baseURI = "https://api.themoviedb.org/3";

        String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxOTc1Y2Q0MWQ3YTUxNmMxOTQzNjE1ODkxOTdiMjFhNiIsIm5iZiI6MTczMjA4OTM4OC45OCwic3ViIjoiNjczZDk2MmM4ZTM1N2EyZGVkOTU4NTllIiwic2NvcGVzIjpbImFwaV9yZWFkIl0sInZlcnNpb24iOjF9.YbbyukT8g7E_INqS_2P5ItPOuQ31mn8jZhEcQ--o2AE"; // Bearer Token
        int movieId = 27205; // Example: Inception movie ID

        Response response = given()
                .header("Authorization", "Bearer " + bearerToken)
                .header("Content-Type", "application/json;charset=utf-8")
                .pathParam("movie_id", movieId)
                .when()
                .delete("/movie/{movie_id}/rating")
                .then()
                .statusCode(200)
                .body("status_code", equalTo(13))
                .body("status_message", equalTo("The item/record was deleted successfully."))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
