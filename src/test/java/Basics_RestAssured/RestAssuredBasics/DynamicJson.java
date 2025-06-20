package Basics_RestAssured.RestAssuredBasics;

import Basics_RestAssured.files.ReUsableMethods;
import Basics_RestAssured.files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {

    @Test(description="Add Book and delete the same books",
            dataProvider = "BooksData")
    public void addBook(String aisle, String isbn) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json").body(payload.addBook(aisle, isbn))
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = ReUsableMethods.rawToString(response);
        String res = js.get("ID");
        System.out.println(res);


        given().log().all().header("Content-Type", "application/json").body(payload.addBook(aisle, isbn))
                .when()
                .delete("/Library/Addbook.php")
                .then().assertThat().statusCode(200);
    }

    @DataProvider(name="BooksData")
    public Object[][] getData(){
        return new Object[][] {{"iuryfglkjn","41234567654"},{"desfs","5654435"},{"sfdsgvs","98576"}};
    }
}
