package ru.playrix.autotests.helpers.api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import ru.playrix.autotests.filters.CustomLogFilter;

import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification request = with()
            .baseUri("https://playrix.com")
            //.basePath("/games")
            //.header("Language", "ru")
            .filter(CustomLogFilter.customLogFilter().withCustomTemplates())
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            //.expectBody(containsString("success"))
            .build();
}