import Utility.ParentPage;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class MovieList extends ParentPage {
    @Test
    public void nowPlaying() {

        given()
                .spec(reqSpec)
                .when()
                .get("movie/now_playing")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void popular() {

        given()
                .spec(reqSpec)
                .when()
                .get("movie/popular")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void topRated() {

        given()
                .spec(reqSpec)
                .when()
                .get("movie/top_rated")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void upComing() {

        given()
                .spec(reqSpec)
                .when()
                .get("movie/upcoming")
                .then()
                .log().body()
                .statusCode(200);
    }
}
