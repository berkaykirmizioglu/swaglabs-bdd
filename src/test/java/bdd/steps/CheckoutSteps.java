package bdd.steps;

import bdd.pages.CheckoutPage;
import bdd.utils.wait.PageWaits;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutSteps extends UIInteractionSteps {

    @Step("Fill Checkout Information Form")
    public CheckoutSteps fillCheckoutForm(String firstName, String lastName, String zipCode) {

        new PageWaits().waitForPageToCompleteState(getDriver());
        $(CheckoutPage.CHECKOUT_FORM_FIRSTNAME).typeAndTab(firstName);
        $(CheckoutPage.CHECKOUT_FORM_LASTNAME).typeAndTab(lastName);
        $(CheckoutPage.CHECKOUT_FORM_ZIP_CODE).typeAndTab(zipCode);

        return this;
    }

    @Step("Fill Checkout Information Form")
    public void submitCheckoutForm() {

        $(CheckoutPage.CONTINUE_BUTTON).click();
    }

    @Step("Checks checkout informations are correct")
    public void isCheckoutInfoCorrect(String title, String price, String paymentInfo,
                                      String shippingInfo, String itemTotal, String tax )
    {
        for (WebElement product : getCheckoutProducts()){
            Assert.assertTrue("Product Title isn't correct!", product.getText().contains(title));
            Assert.assertTrue("Product Price isn't correct!", product.getText().contains(price));
        }

        String summaryInfo = $(CheckoutPage.SUMMARY_INFO).getText();

        Assert.assertTrue("Payment Informations aren't correct!", summaryInfo.contains(paymentInfo));
        Assert.assertTrue("Shopping Informations aren't correct!", summaryInfo.contains(shippingInfo));
        Assert.assertTrue("Item Total isn't correct!", summaryInfo.contains(itemTotal));
        Assert.assertTrue("Tax isn't correct!", summaryInfo.contains(tax));
    }

    private List<WebElement> getCheckoutProducts() {
        return getDriver().findElements(By.className("cart_item"));
    }
}
