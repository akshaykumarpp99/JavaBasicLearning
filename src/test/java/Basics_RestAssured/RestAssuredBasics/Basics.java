package Basics_RestAssured.RestAssuredBasics;

import Basics_RestAssured.files.ReUsableMethods;
import Basics_RestAssured.files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args){

//        Given: Take all input details to submit an API
//        When: Submit the API with Request methods(Get, Post, Put, Patch, Delete)
//        Then: Validate the response

        RestAssured.baseURI="https://rahulshettyacademy.com";
        String response = given().log().all().relaxedHTTPSValidation().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(payload.addPlace())
                .when().post("maps/api/place/add/json")
                 .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");
        System.out.println(placeId);
//        Add place -> Update place with new address -> Get place to validate if new address is present in response

//        Update Place

        String newAdd = "Summer camp, NY";

        given().log().all().relaxedHTTPSValidation().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body("{\n" +
                        "    \"place_id\": \""+placeId+"\",\n" +
                        "    \"address\": \""+newAdd+"\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}")
                .when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

//        Get Place

        String getPlaceResponse = given().log().all().relaxedHTTPSValidation().queryParam("key", "qaclick123")
                .queryParam("place_id",placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

//        JsonPath js1 = new JsonPath(getPlaceResponse);
        JsonPath js1 = ReUsableMethods.rawToString(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAdd);


    }
}
