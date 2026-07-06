package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticePage {
    WebDriver driver;

    By practicePageTitle_xpath = By.xpath("//button[@id='tab-btn-web']");
    By practicePageInventoryFromRequirements_xpath = By.xpath("//summary[normalize-space()='Inventory Form Requirements']");
    By inventoryFormRequirementsDetails = By.xpath(
            "//details[.//summary[normalize-space()='Inventory Form Requirements']]");
    By inventoryFormRequirementsContent = By.xpath(
            "//details[.//summary[normalize-space()='Inventory Form Requirements']]//*[contains(normalize-space(.), 'End-to-End Flow')]");
    By deviceTypeSelect = By.id("deviceType");
    By brandSelect = By.id("brand");
    By devicePreview = By.id("device-preview");
    By iphonePreviewImage = By.cssSelector("#device-preview img[src*='iphone']");
    By iphone128GigStorageOption = By.id("storage-128GB");
    By iphoneColorSelect = By.id("color");
    By iphoneQuantityEnteredTextbox = By.id("quantity");
    By iphoneEnterAddressTextbox_xpath = By.xpath("//input[@id='address']");
    By nextButton_xpath = By.xpath("//button[@id='inventory-next-btn']");

    By deviceSummary = By.id("device-summary-title");

    By ShippingMethod = By.id("shipping-option-express");
    By shippingExpressRadio = By.id("shipping-express");

    By warranty1YearLabel = By.id("warranty-option-1yr");
    By warranty1YearRadio = By.id("warranty-1yr");

    By discountCodeInput_xpath = By.xpath("//input[@id='discount-code']");
    By discountCodeApplyButton = By.id("apply-discount-btn");
    By discountCodeAppliedText = By.id("discount-feedback");

    By confirmPurchaseButton = By.id("purchase-device-btn");
    By orderSuccessfullMessageText_xpath = By.xpath("//h4[contains(normalize-space(.), 'ORDER SUCCESSFUL')]");
    By viewInvoiceButton_xpath = By.xpath("//button[@id='view-history-btn']");
    By invoiceHistoryTitle = By.xpath("//h3[contains(normalize-space(.), 'Invoice History')]");

    By invoiceViewButton = By.xpath("//button[starts-with(@id,'view-invoice-')]");
    

   
    
    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebTabButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(practicePageTitle_xpath));
        title.click();
    }

    public void clickInventoryFromRequirements() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement summary = wait.until(
                ExpectedConditions.elementToBeClickable(practicePageInventoryFromRequirements_xpath));
        summary.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryFormRequirementsContent));
    }

    public boolean isInventoryFormRequirementsExpanded() {
        WebElement details = driver.findElement(inventoryFormRequirementsDetails);
        return details.getAttribute("open") != null;
    }

    public String getInventoryFormRequirementsContentText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryFormRequirementsContent));
        return content.getText().trim();
    }

    public void selectPhone() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement deviceType = wait.until(ExpectedConditions.visibilityOfElementLocated(deviceTypeSelect));
        new Select(deviceType).selectByVisibleText("Phone");
        wait.until(driver -> new Select(driver.findElement(brandSelect)).getFirstSelectedOption().getText().contains("Select brand"));
    }

    public String getSelectedDeviceType() {
        WebElement deviceType = driver.findElement(deviceTypeSelect);
        return new Select(deviceType).getFirstSelectedOption().getText().trim();
    }

    public boolean isBrandDropdownEnabled() {
        return driver.findElement(brandSelect).isEnabled();
    }

    public void selectApple() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement brand = wait.until(ExpectedConditions.elementToBeClickable(brandSelect));
        new Select(brand).selectByVisibleText("Apple");
        wait.until(ExpectedConditions.visibilityOfElementLocated(iphonePreviewImage));
    }

    public void selectIphone() {
        selectPhone();
        selectApple();
    }

    public String getSelectedBrand() {
        WebElement brand = driver.findElement(brandSelect);
        return new Select(brand).getFirstSelectedOption().getText().trim();
    }

    public boolean isIphonePreviewDisplayed() {
        return driver.findElement(iphonePreviewImage).isDisplayed();
    }

    public String getDevicePreviewText() {
        return driver.findElement(devicePreview).getText().trim();
    }

    public void select128GigStorageOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement storageOption = wait.until(ExpectedConditions.elementToBeClickable(iphone128GigStorageOption));
        storageOption.click();
        wait.until(ExpectedConditions.elementToBeClickable(iphoneColorSelect));
    }

    public boolean is128GigStorageOptionSelected() {
        WebElement storageOption = driver.findElement(iphone128GigStorageOption);
        return storageOption.getAttribute("aria-checked") != null && storageOption.getAttribute("aria-checked").equals("true");
    }

    public void selectBlackColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement colorSelect = wait.until(ExpectedConditions.elementToBeClickable(iphoneColorSelect));
        new Select(colorSelect).selectByVisibleText("Pink");
    }

    public void selectPinkColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement colorSelect = wait.until(ExpectedConditions.elementToBeClickable(iphoneColorSelect));
        new Select(colorSelect).selectByVisibleText("Pink");
    }

    public void selectBlueColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement colorSelect = wait.until(ExpectedConditions.elementToBeClickable(iphoneColorSelect));
        new Select(colorSelect).selectByVisibleText("Blue");
    }

    public String getSelectedDeviceColor() {
        WebElement colorSelect = driver.findElement(iphoneColorSelect);
        return new Select(colorSelect).getFirstSelectedOption().getText().trim();
    }

    public void enterQuantity(int quantity) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement quantityTextbox = wait.until(ExpectedConditions.elementToBeClickable(iphoneQuantityEnteredTextbox));
        quantityTextbox.clear();
        quantityTextbox.sendKeys(String.valueOf(quantity));
    }

    public String getEnteredQuantity() {
        WebElement quantityTextbox = driver.findElement(iphoneQuantityEnteredTextbox);
        return quantityTextbox.getAttribute("value").trim();
    }

    public void enterAddress(String address) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement addressTextbox = wait.until(ExpectedConditions.elementToBeClickable(iphoneEnterAddressTextbox_xpath));
        addressTextbox.clear();
        addressTextbox.sendKeys(address);
    }

    public String getEnteredAddress() {
        WebElement addressTextbox = driver.findElement(iphoneEnterAddressTextbox_xpath);
        return addressTextbox.getAttribute("value").trim();
    }

    public boolean isAddressTextboxDisplayed() {
        return driver.findElement(iphoneEnterAddressTextbox_xpath).isDisplayed();
    }

    public void clickNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextButton_xpath));
        nextButton.click();
    }

    public boolean isNextButtonDisplayed() {
        return driver.findElement(nextButton_xpath).isDisplayed();
    }

    public String getDeviceSummary() {
        return driver.findElement(deviceSummary).getText().trim();
    }

    public void selectShippingMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement shippingMethod = wait.until(ExpectedConditions.elementToBeClickable(ShippingMethod));
        shippingMethod.click();
        wait.until(driver -> driver.findElement(shippingExpressRadio).isSelected());
    }

    public boolean isShippingMethodSelected() {
        return driver.findElement(shippingExpressRadio).isSelected();
    }

    public void selectWarrantyOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement warrantyLabel = wait.until(ExpectedConditions.elementToBeClickable(warranty1YearLabel));
        warrantyLabel.click();
        wait.until(driver -> driver.findElement(warranty1YearRadio).isSelected());
    }

    public boolean isWarrantyOptionSelected() {
        return driver.findElement(warranty1YearRadio).isSelected();
    }

    public void enterDiscountCode(String discountCode) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement discountCodeInput = wait.until(ExpectedConditions.elementToBeClickable(discountCodeInput_xpath));
        discountCodeInput.clear();
        discountCodeInput.sendKeys(discountCode);
    }

    public void clickDiscountCodeApplyButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement applyButton = wait.until(ExpectedConditions.elementToBeClickable(discountCodeApplyButton));
        applyButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(discountCodeAppliedText));
    }

    public boolean isDiscountCodeApplied() {
        return driver.findElement(discountCodeAppliedText).isDisplayed();
    }

    public String getDiscountCodeAppliedText() {
        return driver.findElement(discountCodeAppliedText).getText().trim();
    }

    public void clickConfirmPurchaseButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(confirmPurchaseButton));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", confirmButton);
        confirmButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewInvoiceButton_xpath));
    }

    public boolean isConfirmPurchaseButtonDisplayed() {
        return driver.findElement(confirmPurchaseButton).isDisplayed();
    }

    public void clickViewInvoiceButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement viewButton = wait.until(ExpectedConditions.presenceOfElementLocated(viewInvoiceButton_xpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", viewButton);
        wait.until(ExpectedConditions.visibilityOf(viewButton));
        js.executeScript("arguments[0].click();", viewButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceHistoryTitle));
    }

    public boolean isViewInvoiceButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(viewInvoiceButton_xpath)).isDisplayed();
    }

    public boolean isInvoiceHistoryDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceHistoryTitle)).isDisplayed();
    }

    public String getOrderSuccessfullMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(orderSuccessfullMessageText_xpath));
        return message.getText().trim();
    }

    public String getViewInvoiceButtonText() {
        WebElement viewButton = driver.findElement(viewInvoiceButton_xpath);
        return viewButton.getText().trim();
    }

    public void clickViewButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(invoiceViewButton));
        viewButton.click();
    }

    public boolean isViewButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceViewButton)).isDisplayed();
    }

    public String getViewButtonText() {
        WebElement viewButton = driver.findElement(invoiceViewButton);
        return viewButton.getText().trim();
    }

    public String getInvoiceHistoryTitle() {
        return driver.findElement(invoiceHistoryTitle).getText().trim();
    }

    public String getInvoiceHistoryText() {
        return getInvoiceHistoryTitle();
    }
}
