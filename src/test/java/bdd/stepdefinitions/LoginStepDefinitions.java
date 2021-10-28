package bdd.stepdefinitions;

import bdd.steps.LoginSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    LoginSteps loginSteps;

    @Given("^User on the login page$")
    public void userOnTheLoginPage() {

        loginSteps.openLoginPage();
    }

    @Given("^User submit login form with credentials$")
    public void userSubmitLoginForm(List<Map<String, String>> credentials) {
        Map<String, String> credential = credentials.get(0);

        loginSteps.fillLoginForm(credential.get("username"), credential.get("password")).submit();
    }

    @Then("^User should see error message as \"([^\"]*)\" at the Login Page$")
    public void userShouldSeeErrorMessage(String errorMessage) {

        Assert.assertEquals("Error messages are not matching!", errorMessage, loginSteps.getErrorMessage());
    }
}
