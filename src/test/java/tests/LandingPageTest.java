package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LandingPage;
import pages.LoginPage;
import utils.Base;
import utils.BrowserFactory;

public class LandingPageTest extends Base {

    @BeforeMethod
    public void setUp() {
        setup();
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

    @Test(priority = 0)
    public void testLandingPageDisplaysTresor() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);

        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();

        String title = landingPage.getLandingPageTitle();
        Assert.assertEquals(title, "Tresor");
    }

    @Test(priority = 1)
    public void testLandingPageLearnMenuButton() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);

        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        loginPage.waitForLoginSuccess();

        landingPage.clickLandingPageLearnMenuButton();
        Assert.assertTrue(landingPage.getLearnMenuCurriculumText().contains("Curriculum"));
    }

    @Test(priority = 2)
    public void testClickLearningMaterials() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        loginPage.waitForLoginSuccess();

        landingPage.clickLandingPageLearnMenuButton();
        Assert.assertTrue(landingPage.getLearningMaterialsText().contains("Learning Materials"));
        landingPage.clickLearningMaterials();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
    }
    

    
}
