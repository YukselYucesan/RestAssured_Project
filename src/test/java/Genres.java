import Utility.ParentPage;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Genres extends ParentPage {
    @Test
    public void moveList() {

        given()
                .spec(reqSpec)
                .when()
                .get("genre/movie/list")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void tvList() {

        given()
                .spec(reqSpec)
                .when()
                .get("genre/tv/list")
                .then()
                .statusCode(200);
    }
}
