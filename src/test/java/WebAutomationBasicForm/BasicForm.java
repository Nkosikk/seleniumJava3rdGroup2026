package WebAutomationBasicForm;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BasicForm {

    WebDriver driver;

    @Test
    public void basicFormPracticeTest() throws InterruptedException {

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button")).click();
        driver.findElement(By.id("login-email")).sendKeys("yolandamasiza@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("Masiza@1988");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(2000);

        String welcomeText = driver.findElement(
                By.xpath("//*[@id='app-main-content']//h2")
        ).getText();
        System.out.println("Welcome Text = " + welcomeText);

        Assert.assertTrue(welcomeText.contains("Welcome"));

        // Click Learn
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.nav-dropdown-trigger")
                )
        ).click();

// Click Learning Materials
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Learning Materials']")
                )
        ).click();

// Click Web Automation Basic Form
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("tab-btn-password")
                )
        ).click();

// Expand Basic Form Requirements
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//summary[contains(.,'Basic Form Requirements')]")
                )
        ).click();
    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }


}
