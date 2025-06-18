package Basics_RestAssured.RestAssuredBasics;

import Basics_RestAssured.files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(payload.coursePrice());

        int count = js.getInt("courses.size()");
        System.out.println(count);

        int pAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(pAmount);

        String firstTitle = js.getString("courses[0].title");
//        System.out.println(firstTitle);

//        Extracting all titles and prices of the courses
        for(int i=0;i<count;i++){
            String title = js.get("courses["+i+"].title");
            int price = js.get("courses["+i+"].price");
            System.out.println(title);
            System.out.println(price);
        }

//        Extracting the total number of RPA Copies sold
        for(int i=0;i<count;i++){
            String title = js.get("courses["+i+"].title");
            if(title.equalsIgnoreCase("RPA")){
                int copies = js.get("courses["+i+"].copies");
                System.out.println("RPA Copies: "+copies);
                break;
            }
        }

//        Sum all prices and validate with total purchase amount

        int sum = 0;

        for(int i=0;i<count;i++){
            int price = js.get("courses["+i+"].price");
            int numOfCopies = js.get("courses["+i+"].copies");
            sum += (price*numOfCopies);
        }

        if(sum == pAmount){
            System.out.println("Amount is matching");
        } else {
            System.out.println("Amount mismatch");
        }


    }
}
