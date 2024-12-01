import Utility.ConfigReader;
import Utility.ParentPage;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Account extends ParentPage {
    String getLogin="https://www.themoviedb.org/login";

    @Test
    public void Login(){

        given()
                .spec(reqSpec)
                .when()
                .get(getLogin)
                .then()
                .statusCode(200)
        ;
    }

    @Test
    public void Account(){

        given()
                .spec(reqSpec)
                .when()
                .get("account")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test
    public void addFavorite(){
        Map<String,String> addFavorite =new HashMap<>();
        addFavorite.put("media_type","movie");
        addFavorite.put("media_id","550");
        addFavorite.put("favorite","true");

        given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(addFavorite)
                .when()
                .post("account/"+ ConfigReader.getProperty("AccountID")+"/favorite")
                .then()
                .log().body()
                .statusCode(201)
                .body("status_message", containsString("updated successfully."))
        ;
    }

    @Test
    public void addToWatchList(){

        Map<String,String> addWatchList =new HashMap<>();
        addWatchList.put("media_type","movie");
        addWatchList.put("media_id","11");
        addWatchList.put("watchlist","true");

        given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(addWatchList)
                .when()
                .post("account/"+ConfigReader.getProperty("AccountID")+"/watchlist")
                .then()
                .log().body()
                .statusCode(201)
                .body("status_message",containsStringIgnoringCase("updated successfully."))
        ;
    }

    @Test
    public void favoriteMovies(){

        given()
                .spec(reqSpec)
                .when()
                .get("account/"+ConfigReader.getProperty("AccountID")+"/favorite/movies")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test
    public void favoriteTv(){

        given()
                .spec(reqSpec)
                .when()
                .get("account/"+ConfigReader.getProperty("AccountID")+"/favorite/tv")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test
    public void ratedMovies(){

        given()
                .spec(reqSpec)
                .when()
                .get("account/"+ConfigReader.getProperty("AccountID")+"/rated/movies")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test
    public void ratedTv(){

        given()
                .spec(reqSpec)
                .when()
                .get("account/"+ConfigReader.getProperty("AccountID")+"/rated/tv")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test
    public void watchListMovies(){

        given()
                .spec(reqSpec)
                .when()
                .get("account/"+ConfigReader.getProperty("AccountID")+"/watchlist/movies")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }

    @Test
    public void watchListTv(){

        given()
                .spec(reqSpec)
                .when()
                .get("account/"+ConfigReader.getProperty("AccountID")+"/watchlist/tv")
                .then()
                .log().body()
                .statusCode(200)
        ;
    }
}
