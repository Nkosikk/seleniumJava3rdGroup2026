package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utils.Base;

public class NdosiTests extends Base {


    @Test
    public void loginTest()  {
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("nkwanyana@gmail.com");
        loginPage.enterPassword("#12345678");
        loginPage.clickLoginButton();
        landingPage.welcomeText();
    }

    @Test
    public void contactUsTest() {
        contactUsPage.clickContactUsButton();
        contactUsPage.contactMethodsText();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
