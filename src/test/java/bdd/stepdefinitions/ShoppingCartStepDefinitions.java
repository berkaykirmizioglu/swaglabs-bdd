package bdd.stepdefinitions;

import bdd.pages.ShoppingCartPage;
import bdd.steps.ShoppingCartSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class ShoppingCartStepDefinitions {

    ShoppingCartSteps shoppingCartSteps;

    @Then("User checks product price again as \"([^\"]*)\" at the Cart Page$")
    public void checkProductPrice(String expectedPrice) {

        String actualProductPrice = shoppingCartSteps.$(ShoppingCartPage.PRODUCT_PRICE).getText();
        Assert.assertEquals("Added product's price is not expected!", expectedPrice, actualProductPrice);
    }

    @When("^User click to Checkout button$")
    public void userClickToCheckoutButton() {

        shoppingCartSteps.$(ShoppingCartPage.CHECKOUT_BUTTON).click();
    }
}
