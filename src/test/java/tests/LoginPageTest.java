package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("admin@gmail.com");
        loginPage.enterPassword("@12345678");
        loginPage.clickLoginButtonToSubmit();
    }
}
