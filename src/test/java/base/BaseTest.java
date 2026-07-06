package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import WebAutomationAdvance.utils.DriverManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = DriverManager.getDriver();
        driver.get("https://ndosisimplifiedautomation.vercel.app/");
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }
}