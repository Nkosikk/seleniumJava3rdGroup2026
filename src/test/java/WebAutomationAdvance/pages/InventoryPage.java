package WebAutomationAdvance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By webAutomationTab =
            By.xpath("//span[text()='Web Automation Advance']");

    By deviceType = By.id("deviceType");
    By brand = By.id("brand");
    By storage128 = By.id("storage-128GB");
    By color = By.id("color");
    By quantity = By.id("quantity");
    By address = By.id("address");
    By nextBtn = By.id("inventory-next-btn");

    public void openWebAutomationAdvanced() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.elementToBeClickable(webAutomationTab)
        ).click();
    }

    public void selectDeviceType() {
        new Select(driver.findElement(deviceType))
                .selectByVisibleText("Phone");
    }

    public void selectBrand() {
        new Select(driver.findElement(brand))
                .selectByVisibleText("Apple");
    }

    public void selectStorage() {
        driver.findElement(storage128).click();
    }

    public void selectColor() {
        new Select(driver.findElement(color))
                .selectByVisibleText("Blue");
    }

    public void enterQuantity() {
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys("2");
    }

    public void enterAddress() {
        driver.findElement(address)
                .sendKeys("123 Test Street");
    }

    public void clickNext() {
        driver.findElement(nextBtn).click();
    }

    public void completeInventoryForm() {

        selectDeviceType();
        selectBrand();
        selectStorage();
        selectColor();
        enterQuantity();
        enterAddress();
        clickNext();
    }
}