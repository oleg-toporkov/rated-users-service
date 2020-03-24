package web;

import org.junit.jupiter.api.Test;
import web.pages.HomePage;
import web.pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest {

    @Test
    void goToLoginPageTest() {
        HomePage.openHomePage();
        HomePage.clickLogin();

        LoginPage.waitForPageToLoad();
        assertThat(LoginPage.isLoginButtonVisible(), is(true));
        assertThat(LoginPage.isLoginFieldVisible(), is(true));
        assertThat(LoginPage.isPasswordFieldVisible(), is(true));
    }

}
