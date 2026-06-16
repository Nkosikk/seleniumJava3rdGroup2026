package automateTheBasicFormGift;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomateBasicFormGift {

    WebDriver driver;

    @BeforeTest
    public void launchUrl() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
    }
    @Test
    public void clickLoginTest(){
        driver.findElement(By.xpath("//*[@id=\"app-root\"]/nav/div[1]/div[3]/button")).click();
    }
    @Test (dependsOnMethods = "clickLoginTest")
    public void enterUsernameTest(){
        driver.findElement(By.xpath("//input[@id = 'login-emaill']")).sendKeys("gcmakofane@gmail.com");
    }
    @Test (dependsOnMethods = "enterUsernameTest")
    public void enterPasswordTest(){
        driver.findElement(By.xpath("//input[@id = 'login-password']")).sendKeys("Ndosi_TestSite1");
    }
    @Test(dependsOnMethods = "enterPasswordTest")
    public void loginToNdosiWebsite() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id = 'login-submit']")).click();
        Thread.sleep(3000);
    }
    @Test(dependsOnMethods = "loginToNdosiWebsite")
    public void validateLoginTest(){
        String validateLoginText =   driver.findElement(By.xpath("//span[text() = 'back,']")).getText();
        System.out.println(validateLoginText);
        Assert.assertEquals(validateLoginText, "back,");
    }
    @Test(dependsOnMethods = "validateLoginTest")
    public void clickLearnTest(){
        driver.findElement(By.xpath("//span[text() = 'Learn']")).click();
    }
    @Test(dependsOnMethods = "clickLearnTest")
    public void clickLearningMaterials(){
        driver.findElement(By.xpath("//button[contains(@class, 'nav-dropdown-item ')]//span[text() = 'Learning Materials']")).click();
    }
    @Test(dependsOnMethods = "clickLearningMaterials")
    public void clickOnWebAutomationBasicFormTest(){
        driver.findElement(By.xpath("//button[@id = 'tab-btn-password']//span[text() = 'Web Automation Basic Form']")).click();
    }
    @Test(dependsOnMethods = "clickOnWebAutomationBasicFormTest")
    public void expandBasicFormRequirementTets(){
        driver.findElement(By.xpath("//details[@id = 'basic-form-requirements']")).click();
    }
//    @AfterTest
//    public void closeBrowser(){
//        driver.quit();
//    }


}
