package bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:swaglabs.inventory.page")
public class InventoryPage extends PageObject {

    public static final By HEADER_TITLE = By.className("title");
    public static final By SHOPPING_CART_LINK = By.className("shopping_cart_link");
    public static final By INVENTORY_ITEMS = By.className("inventory_list");

}