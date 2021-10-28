package bdd.steps;

import bdd.pages.LoginPage;
import bdd.utils.wait.PageWaits;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginSteps extends UIInteractionSteps {

    LoginPage loginPage;

    @Step("Open login page.")
    public void openLoginPage() {

        loginPage.open();
    }

    @Step("Fill login form as Username: {0}, Password: {1}")
    public LoginSteps fillLoginForm(String username, String password) {

        new PageWaits().waitForPageToCompleteState(getDriver());
        $(LoginPage.USERNAME_FIELD).typeAndTab(username);
        $(LoginPage.PASSWORD_FIELD).type(password);

        return this;
    }

    @Step("Submit login form")
    public void submit() {

        new PageWaits().waitForPageToCompleteState(getDriver());
        $(LoginPage.LOGIN_BUTTON).click();
    }

    @Step("Read Error Message from Login Form")
    public String getErrorMessage() {

        new PageWaits().waitForPageToCompleteState(getDriver());
        return getDriver().findElement(By.xpath("//div[@class='error-message-container error']/*[@data-test='error']")).getText();
    }
}
