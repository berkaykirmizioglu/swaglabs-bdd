package bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WithByLocator;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:swaglabs.login.page")
public class LoginPage extends PageObject {

    public static final By USERNAME_FIELD = By.cssSelector("#user-name");
    public static final By PASSWORD_FIELD = By.cssSelector("#password");
    public static final By LOGIN_BUTTON = By.cssSelector("#login-button");
}