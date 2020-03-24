package web.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private static final String homePageUrl = "https://www.ebay-kleinanzeigen.de"; //TODO move me to config
    private static final By loginButton = By.xpath("//a[@data-gaevent='Homepage,LoginBegin']//..");


    public static void openHomePage() {
        open(homePageUrl);
    }

    public static void clickLogin() {
        element(loginButton).click();
    }
}
