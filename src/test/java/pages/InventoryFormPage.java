package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryFormPage {
    WebDriver driver;
    WebDriverWait wait;

    public  InventoryFormPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // ===================== LOCATORS =====================

    By deviceType_id = By.id("deviceType");
    By brand_id = By.id("brand");
    By color_id = By.id("color");
    By quantity_id = By.id("quantity");
    By address_id = By.id("address");
    By discountCode = By.id("discount-code");

    By nextButton_xpath = By.xpath("//button[contains(text(),'Next')]");
    By applyDiscount = By.xpath("//button[contains(text(),'Apply')]");
    By confirmPurchase = By.xpath("//button[contains(text(),'Confirm Purchase')]");
    By learnButton_xpath= By.xpath("//div[@id='app-root']/nav/div/div[2]/div/button/span[3]");
    By learningMaterialBtn_xpath = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]");
    By webAutomationAdvanceBtn_xpath = By.xpath("//*[@id=\"tab-btn-web\"]");



    // ===================== DYNAMIC METHODS =====================

    private void clickByDynamicId(String prefix, String value) {

        String locator = prefix + value.toLowerCase();

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));element.click();
    }

    public void selectShippingMethod(String shipping) {

        clickByDynamicId("shipping-option-", shipping);
    }

    public void selectWarranty(String warranty) {

        clickByDynamicId("warranty-option-", warranty);
    }

   // public void selectStorage(String storage) {

        ///wait.until(ExpectedConditions.elementToBeClickable(By.id("storage-" + storage))).click();
    //}

  // ===================== BUSINESS LOGIC =====================

    public void purchasePhone() throws InterruptedException {

        driver.findElement(learnButton_xpath).click();
        Thread.sleep(2000);
        driver.findElement(learningMaterialBtn_xpath).click();
        driver.findElement(webAutomationAdvanceBtn_xpath).click();
        new Select(driver.findElement(deviceType_id)).selectByVisibleText("Phone");
        Thread.sleep(2000);
        new Select(driver.findElement(brand_id)).selectByVisibleText("Apple");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='storage-128GB']"))).click();
        Thread.sleep(2000);
        new Select(driver.findElement(color_id)).selectByVisibleText("Blue");

        driver.findElement(quantity_id).clear();
        driver.findElement(quantity_id).sendKeys("2");
        Thread.sleep(2000);
        driver.findElement(address_id).sendKeys("123 Test Street");
        Thread.sleep(2000);
        driver.findElement(nextButton_xpath).click();
        Thread.sleep(2000);

        //Dynamic Shipping
        selectShippingMethod("express");
        Thread.sleep(5000);

        //Dynamic Warranty
        selectWarranty("1yr");

        driver.findElement(applyDiscount).sendKeys("SAVE10");
        wait.until(ExpectedConditions.visibilityOfElementLocated(discountCode)).sendKeys("SAVE10");
        wait.until(ExpectedConditions.elementToBeClickable(applyDiscount)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmPurchase)).click();

    }

    public String getToastMessage() {
        By toastTitle = By.xpath("//div[@id='purchase-success-toast']//h4");

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastTitle)
        ).getText().trim();
    }


}
