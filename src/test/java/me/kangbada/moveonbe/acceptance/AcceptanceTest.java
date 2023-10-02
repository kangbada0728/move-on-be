package me.kangbada.moveonbe.acceptance;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import me.kangbada.moveonbe.dto.jobpostcontroller.JobPostingCompanyDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AcceptanceTest {
    public static final String NHN = "NHN";
    public static final String JOB_POSTINGS_URI = "/job/postings";
    public static final String JOB_POSTING_RESPONSE_FIELD = "jobPostingCompanies";

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
        URI uri = URI.create(JOB_POSTINGS_URI);
        ExtractableResponse<Response> extractResponse = RestAssured.given().log().all()
                .accept(ContentType.JSON)
                .port(port)
                .when()
                .get(uri)
                .then()
                .extract();

        JsonPath jsonPath = extractResponse.jsonPath();
        List<JobPostingCompanyDto> jobPostingCompanies = jsonPath.getList(JOB_POSTING_RESPONSE_FIELD, JobPostingCompanyDto.class);

        assertThat(extractResponse.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(jobPostingCompanies)
                .extracting(JobPostingCompanyDto::getCompanyName)
                .isNotNull()
                .contains(NHN);
    }


}
