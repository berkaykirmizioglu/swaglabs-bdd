package bdd.utils.wait;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageWaits extends UIInteractionSteps {

    public void waitForPageToCompleteState(WebDriver driver) {
        int counter = 0;
        int maxNoOfRetries=15;
        while (maxNoOfRetries > 0 && counter != maxNoOfRetries) {
            waitABit(2000);
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                if (js.executeScript("return document.readyState").toString().equals("complete")) {
                    break;
                }
            } catch (Exception e) {

                System.out.println("No success!");
            }
            counter++;
        }
    }
}
