package WebAutomationAdvance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By homeLoginBtn = By.xpath("//button[contains(.,'Login')]");

    By email = By.id("login-email");
    By password = By.id("login-password");
    By loginBtn = By.id("login-submit");

    public void login(String username, String pwd) {

        // Click Login button on Home page
        driver.findElement(homeLoginBtn).click();

        // Wait for login form
        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(email));

        driver.findElement(email).sendKeys(username);

        driver.findElement(password).sendKeys(pwd);

        driver.findElement(loginBtn).click();
    }
}