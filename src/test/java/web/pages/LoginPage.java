package web.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class LoginPage {

    private static final By loginField = By.name("loginMail");
    private static final By passwordField = By.name("password");
    private static final By loginButton = By.id("login-submit");
    private static final By loginHeader = By.xpath("//h1[text()='Einloggen']");

    public static boolean isLoginFieldVisible() {
        return element(loginField).isDisplayed();
    }

    public static boolean isPasswordFieldVisible() {
        return element(passwordField).isDisplayed();
    }

    public static boolean isLoginButtonVisible() {
        return element(loginButton).isDisplayed();
    }

    public static void waitForPageToLoad() {
        element(loginHeader).waitUntil(Condition.appears, 20000); //TODO move timeout to config
    }

}
