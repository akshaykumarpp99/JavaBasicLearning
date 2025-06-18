package Basics_RestAssured.files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

    public static JsonPath rawToString(String response){

        JsonPath js = new JsonPath(response);
        return js;
    }
}
