package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    By deviceType_id = By.id("deviceType");
    By brand_id = By.id("brand");
    By storage_id = By.id("storage");
    By color_id = By.id("color");
    By quantity_id = By.id("quantity");
    By address_id = By.id("address");

    By nextButton_xpath = By.xpath("//button[contains(text(),'Next')]");
    By expressShipping = By.xpath("//label[contains(text(),'Express Shipping')]");
    By warranty = By.xpath("//label[contains(text(),'1yr Warranty')]");
    By discountCode = By.xpath("//input[contains(@placeholder,'discount')]");
    By applyDiscount = By.xpath("//button[contains(text(),'Apply')]");
    By confirmPurchase = By.xpath("//button[contains(text(),'Confirm Purchase')]");
    By learnButton_xpath= By.xpath("//div[@id='app-root']/nav/div/div[2]/div/button/span[3]");
    By learningMaterialBtn_xpath = By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[2]/div[1]/div/button[2]/span[2]");
    By webAutomationAdvanceBtn_xpath = By.xpath("//*[@id=\"tab-btn-web\"]");


    public void purchasePhone() throws InterruptedException {


        driver.findElement(learnButton_xpath).click();
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
        driver.findElement(expressShipping).click();
        Thread.sleep(5000);
        driver.findElement(warranty).click();
        driver.findElement(applyDiscount).sendKeys("SAVE10");
        driver.findElement(applyDiscount).click();
        driver.findElement(confirmPurchase).click();

    }

    public String getToastMessage() throws InterruptedException {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("Toastify__toast-body"))).getText();
    }


}
