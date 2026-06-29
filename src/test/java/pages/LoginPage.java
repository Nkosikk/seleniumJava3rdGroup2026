package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginPage {

    WebDriver _driver;
    By loginMainButton_xpath = By.xpath("//div[@class='nav-user-section']");
    By username_id = By.id("login-email");

    By password_id = By.id("login-password");
    By loginBtn_id = By.id("login-submit");

    public LoginPage(WebDriver driver){
        _driver = driver;
    }

    public void clickLoginMainButton(){
        _driver.findElement(loginMainButton_xpath).click();
    }

    public  void enterUsername(String username){
        _driver.findElement(username_id).sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement usernameField = _driver.findElement(username_id);
        WebElement passwordField = _driver.findElement(with(By.tagName("input")).below(usernameField));
        passwordField.sendKeys(password);
    }
    
    public void clickLoginButtonToSubmit(){
        _driver.findElement(loginBtn_id).click();
    }
}
