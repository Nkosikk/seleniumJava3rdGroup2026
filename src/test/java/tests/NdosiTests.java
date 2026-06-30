package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.Base;
import utils.TakeScreenshots;

public class NdosiTests extends Base {


    @Test
    public void loginTest() throws InterruptedException {
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("nkwanyana@gmail.com");
        loginPage.enterPassword("#12345678");
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
