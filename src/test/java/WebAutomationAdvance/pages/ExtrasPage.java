package WebAutomationAdvance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExtrasPage {

    WebDriver driver;

    public ExtrasPage(WebDriver driver) {
        this.driver = driver;
    }

    By expressShipping =
            By.id("shipping-option-express");

    By warranty1Year =
            By.id("warranty-option-1yr");

    By discountCode =
            By.id("discount-code");

    By applyDiscount =
            By.id("apply-discount-btn");

    By purchaseBtn =
            By.id("purchase-device-btn");

    public void selectExpressShipping() {
        driver.findElement(expressShipping).click();
    }

    public void selectWarranty() {
        driver.findElement(warranty1Year).click();
    }

    public void applyDiscount() {
        driver.findElement(discountCode)
                .sendKeys("SAVE10");

        driver.findElement(applyDiscount)
                .click();
    }

    public void confirmPurchase() {
        driver.findElement(purchaseBtn).click();
    }

    public void completeExtrasForm() {

        selectExpressShipping();
        selectWarranty();
        applyDiscount();
        confirmPurchase();
    }
}