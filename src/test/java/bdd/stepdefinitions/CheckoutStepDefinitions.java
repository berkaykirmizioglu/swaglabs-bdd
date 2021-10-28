package bdd.stepdefinitions;

import bdd.pages.CheckoutPage;
import bdd.pages.InventoryPage;
import bdd.steps.CheckoutSteps;
import bdd.steps.InventorySteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CheckoutStepDefinitions {

    CheckoutSteps checkoutSteps;

    @And("^User fills checkout information form and submit$")
    public void userFillsCheckoutInformationFormAs(List<Map<String, String>> informations) {
        Map<String, String> info = informations.get(0);

        checkoutSteps.fillCheckoutForm(info.get("firstName"), info.get("lastName"), info.get("zipCode"))
                        .submitCheckoutForm();
    }

    @Then("^User keep check Checkout informations are correct$")
    public void userChecksProductInformations(List<Map<String, String>> informations) {
        Map<String, String> info = informations.get(0);

        checkoutSteps.isCheckoutInfoCorrect(info.get("price"), info.get("title"),info.get("paymentInformation"),
                                            info.get("shippingInformation"), info.get("itemTotal"), info.get("tax"));
    }

    @When("^User finishes order process$")
    public void userFinishesOrderProcess() {
        checkoutSteps.$(CheckoutPage.FINISH_BUTTON).click();
    }

    @Then("^User should see checkout completion status as \"([^\"]*)\"$")
    public void userShouldSeeCompletionStatus(String completionStatus) {

        Assert.assertEquals(completionStatus, checkoutSteps.$(CheckoutPage.CHECKOUT_STATUS_MESSAGE).getText());
    }

    @Then("^User should see order success message as \"([^\"]*)\"$")
    public void userShouldSeeOrderSuccessMessage(String orderSuccessMessage) {

        Assert.assertEquals(orderSuccessMessage, checkoutSteps.$(CheckoutPage.ORDER_SUCCESS_MESSAGE).getText());
    }
}
