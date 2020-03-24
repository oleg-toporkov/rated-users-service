package integration;

import com.ebayk.Application;
import com.ebayk.service.RatingAnalyzer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import util.base.BaseRestAssuredClient;
import util.constants.Endpoints;

import static io.restassured.RestAssured.given;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTests {

    @Value("http://localhost:${local.server.port}")
    private String baseUrl;


    @Test
    void userNotFoundTest() throws RatingAnalyzer.UserNotFoundException {
        int nonExistingUserId = 666;

        //@formatter:off
        given()
                .spec(BaseRestAssuredClient.getBaseRequestSpec(this.baseUrl)).
        when()
                .get(Endpoints.RATED_USERS, nonExistingUserId).
        then()
                .statusCode(HttpStatus.NOT_FOUND.value());
        //@formatter:on
    }

}
