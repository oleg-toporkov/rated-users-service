package util.base;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import util.properties.TestProperties;

import java.util.Collections;

public class BaseRestAssuredClient {

    public static RequestSpecification BASE_REQUEST_SPEC = new RequestSpecBuilder()
            .addFilters(Collections.singletonList(new AllureRestAssured()))
            .log(LogDetail.ALL)
            .setBaseUri(TestProperties.CONFIG.getHost())
            .build();

    public static ResponseSpecification BASE_RESPONSE_SPEC = new ResponseSpecBuilder()
            .expectStatusCode(HttpStatus.SC_OK)
            .log(LogDetail.ALL)
            .build();

    public static RequestSpecification getBaseRequestSpec(String host) {
        return new RequestSpecBuilder()
                .addFilters(Collections.singletonList(new AllureRestAssured()))
                .log(LogDetail.ALL)
                .setBaseUri(host)
                .build();
    }

}