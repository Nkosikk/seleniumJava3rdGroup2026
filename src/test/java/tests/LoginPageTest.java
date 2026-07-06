package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import pages.LandingPage;
import pages.LoginPage;
import utils.Base;
import utils.BrowserFactory;

public class LoginPageTest extends Base {

    @BeforeMethod
    public void setUp() {
        setup();
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

    @Test
    public void testLoginPage() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        Assert.assertEquals(landingPage.getLandingPageTitle(), "Tresor");
    }

    
}
