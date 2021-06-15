package cloud.autotests.tests.cv.api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class Specs {
    public static RequestSpecification request = with()
            .baseUri("https://playrix.com")
            //.basePath("/games")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            //.expectBody(containsString("success"))
            .build();
}