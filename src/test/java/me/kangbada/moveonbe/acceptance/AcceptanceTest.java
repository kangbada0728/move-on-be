package me.kangbada.moveonbe.acceptance;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AcceptanceTest {

    @LocalServerPort
    int port;

    /**
     * Given 
     * When  모든 회사의 채용공고를 가져온다.
     * Then  채용공고 리스트가 가져와진다.
     */
    @DisplayName("모든 회사의 채용공고를 가져온다.")
    @Test
    void 모든_회사의_채용공고를_가져온다() {
        URI uri = URI.create("/companies/job/posting");
        ExtractableResponse<Response> extractResponse = RestAssured.given().log().all()
                .accept(ContentType.JSON)
                .port(port)
                .when()
                .get(uri)
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract();

    }


}
