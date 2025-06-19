package Basics_RestAssured.RestAssuredBasics;

import Basics_RestAssured.files.ReUsableMethods;
import Basics_RestAssured.files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test(description="Add Book")
    public void addBook() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type","application/json").body(payload.addBook())
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = ReUsableMethods.rawToString(response);
        String res = js.get("ID");
        System.out.println(res);
    }
}
