package WebAutomationAdvance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class InvoicePage {

    WebDriver driver;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
    }

    By invoicePanel =
            By.id("invoice-history-panel");

    By openInvoice =
            By.xpath("//button[contains(text(),'View Invoice')]");

    public boolean isInvoicePanelDisplayed() {
        return driver.findElement(invoicePanel)
                .isDisplayed();
    }

    public void openInvoice() {
        driver.findElement(openInvoice).click();
    }

        public void clickViewButton() {

            WebElement viewBtn =
                    driver.findElement(
                            By.xpath("//button[contains(@id,'view-invoice-')]")
                    );

            JavascriptExecutor js =
                    (JavascriptExecutor) driver;

            js.executeScript("arguments[0].click();", viewBtn);


        }
    }