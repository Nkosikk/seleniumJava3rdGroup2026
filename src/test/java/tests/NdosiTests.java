package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.ReadFromDatabase;
import utils.Base;
import utils.TakeScreenshots;

public class NdosiTests extends Base {

    @BeforeClass
    public void setup() {
        ReadFromDatabase.dbConnection();
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginMainButton();
        loginPage.enterUsername(ReadFromDatabase.getUsername);
        loginPage.enterPassword(ReadFromDatabase.getPassword);
        loginPage.clickLoginButton();
        landingPage.welcomeText();
        Thread.sleep(30);
        TakeScreenshots.takeSnapshot(driver, "LoginScreen");
    }

    @Test
    public void contactUsTest() throws InterruptedException {
        contactUsPage.clickContactUsButton();
        contactUsPage.contactMethodsText();
        Thread.sleep(60);
        TakeScreenshots.takeSnapshot(driver, "contactUsScreen");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
