package WebAutomationAdvance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessPage {

    WebDriver driver;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    By successToast =
            By.id("purchase-success-toast");
            By viewInvoiceBtn = By.id("view-history-btn");

    public boolean isSuccessDisplayed() {
        return driver.findElement(successToast).isDisplayed();
    }

    public void clickViewInvoice() throws InterruptedException {

        Thread.sleep(2000);

        WebElement button =
                driver.findElement(viewInvoiceBtn);

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", button);
    }
}