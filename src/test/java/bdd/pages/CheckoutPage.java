package bdd.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:swaglabs.checkout.page")
public class CheckoutPage extends PageObject {

    public static final By CHECKOUT_FORM_FIRSTNAME = By.id("first-name");
    public static final By CHECKOUT_FORM_LASTNAME = By.id("last-name");
    public static final By CHECKOUT_FORM_ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By SUMMARY_INFO = By.className("summary_info");
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By CHECKOUT_STATUS_MESSAGE = By.xpath("//div[@class ='header_secondary_container']//span");
    public static final By ORDER_SUCCESS_MESSAGE = By.xpath("//div[@class ='checkout_complete_container']//h2");

}