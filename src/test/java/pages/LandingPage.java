package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
    WebDriver driver;
    
    By landingPageTitle_xpath = By.xpath("//span[normalize-space()='Tresor']");
    By learnMenuButton = By.xpath(
            "//button[contains(@class,'nav-dropdown-trigger')][.//span[normalize-space()='Learn']]");
    By learnMenuCurriculumItem = By.xpath(
            "//button[contains(@class,'nav-dropdown-item')][contains(normalize-space(.),'Curriculum')]");
    By learningMaterials_xpath = By.xpath("//button[contains(@class,'nav-dropdown-item')][contains(normalize-space(.),'Learning Materials')]");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

        public String getLandingPageTitle() {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(landingPageTitle_xpath));
        return title.getText().trim();
    }

    public void clickLandingPageTitle() {
        driver.findElement(landingPageTitle_xpath).click();
    }

    public void clickLandingPageLearnMenuButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement learnButton = wait.until(ExpectedConditions.elementToBeClickable(learnMenuButton));
        learnButton.click();
    }

    public String getLearnMenuCurriculumText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(learnMenuCurriculumItem));
        return item.getText().trim();
    }

    public String getLearningMaterialsText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(learningMaterials_xpath));
        return item.getText().trim();
    }

    public void clickLearningMaterials() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(learningMaterials_xpath));
        item.click();
        wait.until(ExpectedConditions.urlContains("#practice"));
    }

}
