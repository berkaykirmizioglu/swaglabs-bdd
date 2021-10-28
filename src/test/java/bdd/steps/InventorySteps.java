package bdd.steps;

import bdd.pages.InventoryPage;
import bdd.utils.wait.PageWaits;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventorySteps extends UIInteractionSteps {

    @Step("Get Inventory Page Header Title")
    public String getHeaderTitle() {

        new PageWaits().waitForPageToCompleteState(getDriver());
        return $(InventoryPage.HEADER_TITLE).getText();
    }

    @Step("Sort Products")
    public void sortProducts(String sortingType) {

        new PageWaits().waitForPageToCompleteState(getDriver());

        WebElement sorting = getDriver().findElement(By.xpath("//select//option[contains(.,'" + sortingType + "')]"));
        sorting.click();
        new PageWaits().waitForPageToCompleteState(getDriver());
    }

    @Step("Add to cart with product name & price")
    public void addToCart(String productName, String price) {

        new PageWaits().waitForPageToCompleteState(getDriver());
        List<WebElement> products = getAllProducts();

        for (WebElement product : products) {
            String productDetail = product.getText();
            if (productDetail.contains(productName) && productDetail.contains(price)){
                product.findElement(By.xpath(".//button[contains(@id,'add-to-cart')]")).click();
            }
        }
    }

    private List<WebElement> getAllProducts() {
        new PageWaits().waitForPageToCompleteState(getDriver());
        return getDriver().findElements(By.className("inventory_item"));
    }

    public boolean isBadgeVisible() {
        new PageWaits().waitForPageToCompleteState(getDriver());
        return getDriver().findElement(By.className("shopping_cart_badge")).isDisplayed();
    }
}
