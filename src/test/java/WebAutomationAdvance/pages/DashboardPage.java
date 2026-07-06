package WebAutomationAdvance.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    By learnDropdown =
            By.cssSelector("button.nav-dropdown-trigger");

    By learningMaterials =
            By.xpath("//button[contains(@class,'nav-dropdown-item')]//span[contains(text(),'Learning Materials')]");

    public void openLearningMaterials() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(
                ExpectedConditions.elementToBeClickable(learnDropdown)
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(learningMaterials)
        ).click();
    }
}