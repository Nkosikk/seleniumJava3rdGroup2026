package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class LoginPage {

    WebDriver driver;

    By loginMainButton_xpath = By.xpath( "//div[@class='nav-user-section']" );
    By username_id = By.id( "login-email" );
    By loginButton_id = By.id( "login-submit" );

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginMainButton() {
        driver.findElement( loginMainButton_xpath ).click();
    }

    public void enterUsername(String username) {
        driver.findElement( username_id ).sendKeys( username );
    }

    public void enterPassword(String password) {
        WebElement usernameField = driver.findElement( username_id );
        WebElement passwordField = driver.findElement( with( By.tagName( "input" ) ).below( usernameField ) );
        passwordField.sendKeys( password );
    }

    public void clickLoginButton() {
        driver.findElement( loginButton_id ).click();
    }


}

