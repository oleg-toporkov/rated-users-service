package e2e;

import com.ebayk.data.user.User;
import util.constants.Endpoints;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

import static util.base.BaseRestAssuredClient.BASE_REQUEST_SPEC;
import static util.base.BaseRestAssuredClient.BASE_RESPONSE_SPEC;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RatedUsersTests {

    @Test
    void userNotFoundTest() {
        int nonExistingUserId = 4;

        //@formatter:off
        given()
                .spec(BASE_REQUEST_SPEC).
        when()
                .get(Endpoints.RATED_USERS, nonExistingUserId).
        then()
                .statusCode(HttpStatus.NOT_FOUND.value());
        //@formatter:on
    }

    @Test
    void getEmptyRatedUsersTest() {
        int noRatingsUserId = 1;

        //@formatter:off
        List<User> users =
                given()
                        .spec(BASE_REQUEST_SPEC).
                when()
                        .get(Endpoints.RATED_USERS, noRatingsUserId).
                then()
                        .spec(BASE_RESPONSE_SPEC)
                        .extract()
                        .body()
                        .jsonPath()
                        .getList("", User.class);
        //@formatter:on
        assertThat(users.size(), is(0));
    }

    @Test
    void getRatedUsersTest() {
        int existingUserId = 2;

        //@formatter:off
        List<User> users =
            given()
                    .spec(BASE_REQUEST_SPEC).
            when()
                    .get(Endpoints.RATED_USERS, existingUserId).
            then()
                    .spec(BASE_RESPONSE_SPEC)
                    .extract()
                    .body()
                    .jsonPath()
                    .getList("", User.class);
        //@formatter:on
        assertThat(users.size(), is(1));
        users.forEach(user -> {
            assertThat(user.getId(), is(1));
            assertThat(user.getName(), is("Alice"));

            assertThat(user.getRatings(), notNullValue());
            assertThat(user.getRatings().size(), is(3));

            assertThat(user.getRatings().get(0).getRating(), is(4));
            assertThat(user.getRatings().get(0).getRatingCreatorUserId(), is(2));
            assertThat(user.getRatings().get(1).getRating(), is(5));
            assertThat(user.getRatings().get(1).getRatingCreatorUserId(), is(3));
            assertThat(user.getRatings().get(2).getRating(), is(2));
            assertThat(user.getRatings().get(2).getRatingCreatorUserId(), is(4000));
        });
    }

}
