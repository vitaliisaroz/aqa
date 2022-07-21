package apitests;

import api.models.*;
import api.pojoClasses.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class StarshipsAPITest extends BaseTestAPI {

    private final static String URL = "https://swapi.dev/";

    @Test
    public void getStarshipName() {

        Specifications.installSpec(Specifications.requestSpec(URL), Specifications.responseSpec200());
        List<StarshipsPojo> starships = given()
                .when()
                .get("api/starships/9")
                .then().log().all()
                .extract().body().jsonPath().getList("route", StarshipsPojo.class);

        starships.forEach(x -> Assert.assertTrue(x.getName().equals("Death Star")));
    }
}