package Basics_RestAssured.RestAssuredBasics;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;

public class BugTest {

    @Test
    public void validateJiraBug(){

        RestAssured.baseURI = "https://akshaykumarpp99.atlassian.net/";

        String createIssueResponse = given()
                                .header("Content-Type","application/json")
                                .header("Authorization", "Basic YWtzaGF5a3VtYXJwcDk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBfdnh4UFlhcjRjdmVWSG9OVlFtRXEzNjVrM1JkZ0VwRTVRVF9RVE96b0FhN0dkSy1fLUJ6aTVLT2VxVU1PQzFGMEtYcFhyN2V4WGlDcGQwRDAzMVRKV2FhV1JTWmp4WFppRVJxcWtSRVRITDZIVDRZOFB6d29iM1YwY0JzYjBfN0lfdDZmM3FZVXNVZUVCMWhLZHJ4RkxrdUxjRThJRHZ5cnNhWUQ4b19OdFU9MUM4OEMxMjk=")
                                .body("{\n" +
                                        "    \"fields\": {\n" +
                                        "       \"project\":\n" +
                                        "       {\n" +
                                        "          \"key\": \"SCRUM\"\n" +
                                        "       },\n" +
                                        "       \"summary\": \"Menu Items are not working - Automation.\",\n" +
                                        "       \"issuetype\": {\n" +
                                        "          \"name\": \"Bug\"\n" +
                                        "       }\n" +
                                        "   }\n" +
                                        "}\n")
                                .when()
                                .post("rest/api/3/issue")
                                .then().log().all().assertThat().statusCode(201)
                                .extract().response().asString();

        JsonPath js = new JsonPath(createIssueResponse);
        String issueId = js.get("id");
        System.out.println(issueId);

        given()
                .pathParam("key", issueId)
                .header("X-Atlassian-Token","no-check")
                .header("Authorization", "Basic YWtzaGF5a3VtYXJwcDk5QGdtYWlsLmNvbTpBVEFUVDN4RmZHRjBfdnh4UFlhcjRjdmVWSG9OVlFtRXEzNjVrM1JkZ0VwRTVRVF9RVE96b0FhN0dkSy1fLUJ6aTVLT2VxVU1PQzFGMEtYcFhyN2V4WGlDcGQwRDAzMVRKV2FhV1JTWmp4WFppRVJxcWtSRVRITDZIVDRZOFB6d29iM1YwY0JzYjBfN0lfdDZmM3FZVXNVZUVCMWhLZHJ4RkxrdUxjRThJRHZ5cnNhWUQ4b19OdFU9MUM4OEMxMjk=")
                .multiPart("file", new File("C:\\Users\\JE385EF\\Downloads\\ocr_text.png")).log().all()
                .post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
    }
}
