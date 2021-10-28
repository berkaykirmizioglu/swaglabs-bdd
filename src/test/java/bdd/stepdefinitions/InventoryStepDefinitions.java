package bdd.stepdefinitions;

import bdd.pages.InventoryPage;
import bdd.steps.InventorySteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class InventoryStepDefinitions {

    InventorySteps inventorySteps;

    @Then("^User should be redirected to inventories page and see header title as \"([^\"]*)\"$")
    public void userShouldSeeInventoriesPage(String headerTitle) {

        Assert.assertEquals("Header titles are not matching!", headerTitle, inventorySteps.getHeaderTitle());
    }

    @When("^User sort products as \"([^\"]*)\"$")
    public void userSortProducts(String sortingType) {

        inventorySteps.sortProducts(sortingType);
    }

    @And("User Add To Cart product \"([^\"]*)\" with \"([^\"]*)\" price on the Inventory Page$")
    public void addToCart(String productName, String price) {

        inventorySteps.addToCart(productName, price);
    }

    @Then("Badge should visible and shopping cart should be updated$")
    public void badgeShouldVisible() {

        Assert.assertTrue(inventorySteps.isBadgeVisible());
    }

    @When("User click to Shopping Cart button$")
    public void clickToShoppingCartButton() {

        inventorySteps.$(InventoryPage.SHOPPING_CART_LINK).click();
    }

}
