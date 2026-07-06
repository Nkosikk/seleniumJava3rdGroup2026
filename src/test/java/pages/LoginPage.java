package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver _driver;
    By loginMainButton_xpath = By.xpath("//div[@class='nav-user-section']");
    By username_id = By.id("login-email");
    By password_id = By.id("login-password");
    By loginBtn_id = By.id("login-submit");
    By loginSuccessIndicator = By.xpath("//span[normalize-space()='Tresor']");

    public LoginPage(WebDriver driver){
        _driver = driver;
    }

    public void clickLoginMainButton(){
        _driver.findElement(loginMainButton_xpath).click();
    }

    public void enterUsername(String username){
        _driver.findElement(username_id).clear();
        _driver.findElement(username_id).sendKeys(username);
    }

    public void enterPassword(String password) {
        _driver.findElement(password_id).clear();
        _driver.findElement(password_id).sendKeys(password);
    }
    
    public void clickLoginButtonToSubmit(){
        _driver.findElement(loginBtn_id).click();
    }

    public void waitForLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginSuccessIndicator));
    }
}
