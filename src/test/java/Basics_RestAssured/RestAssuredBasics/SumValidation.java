package Basics_RestAssured.RestAssuredBasics;

import Basics_RestAssured.files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumValidation {

//    To run the Test case we can have this Annotation(@test)
    @Test
    public void sumOfAllPrices(){

        int sum = 0;

        JsonPath js = new JsonPath(payload.coursePrice());
        int count = js.getInt("courses.size()");
        int pAmount = js.getInt("dashboard.purchaseAmount");

        for(int i=0;i<count;i++){
            int price = js.get("courses["+i+"].price");
            int numOfCopies = js.get("courses["+i+"].copies");
            sum += (price*numOfCopies);
        }
        Assert.assertEquals(sum,pAmount);
    }
}
