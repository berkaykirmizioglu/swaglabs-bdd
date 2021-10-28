package bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:swaglabs.cart.page")
public class ShoppingCartPage extends PageObject {

    public static final By PRODUCT_PRICE = By.cssSelector(".inventory_item_price");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
}