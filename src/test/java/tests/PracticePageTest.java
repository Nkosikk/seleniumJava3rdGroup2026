package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

import pages.LandingPage;
import pages.LoginPage;
import pages.PracticePage;
import utils.Base;
import utils.BrowserFactory;

public class PracticePageTest extends Base {

    @BeforeMethod
    public void setUp() {
        setup();
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }

    @Test(priority = 0)
    public void testClickWebTabButton() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        Assert.assertTrue(landingPage.getLearningMaterialsText().contains("Learning Materials"));
        landingPage.clickLearningMaterials();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
        practicePage.clickWebTabButton();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
    }

    @Test(priority = 1)
    public void testClickInventoryFromRequirements() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        Assert.assertTrue(landingPage.getLearningMaterialsText().contains("Learning Materials"));
        landingPage.clickLearningMaterials();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
        practicePage.clickWebTabButton();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
        practicePage.clickInventoryFromRequirements();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
        Assert.assertTrue(practicePage.isInventoryFormRequirementsExpanded());
        Assert.assertTrue(practicePage.getInventoryFormRequirementsContentText().contains("End-to-End Flow"));

    }

    @Test(priority = 2)
    public void testSelectPhone() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);

        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectPhone();

        Assert.assertEquals(practicePage.getSelectedDeviceType(), "Phone");
        Assert.assertTrue(practicePage.isBrandDropdownEnabled());
    }

    @Test(priority = 3)
    public void testSelectIphone() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);

        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();

        Assert.assertEquals(practicePage.getSelectedDeviceType(), "Phone");
        Assert.assertEquals(practicePage.getSelectedBrand(), "Apple");
        Assert.assertTrue(practicePage.isIphonePreviewDisplayed());
        Assert.assertTrue(practicePage.getDevicePreviewText().contains("Apple"));
    }

   
    @Test(priority = 4)
    public void testSelectEndToEndFlow() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        Assert.assertTrue(landingPage.getLearningMaterialsText().contains("Learning Materials"));
        landingPage.clickLearningMaterials();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
        practicePage.clickWebTabButton();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
        practicePage.clickInventoryFromRequirements();
        Assert.assertTrue(BrowserFactory.driver.getCurrentUrl().contains("#practice"));
        Assert.assertTrue(practicePage.isInventoryFormRequirementsExpanded());
        Assert.assertTrue(practicePage.getInventoryFormRequirementsContentText().contains("End-to-End Flow"));
    }

    @Test(priority = 5)   
    public void testSelect128GigStorageOption() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        Assert.assertTrue(practicePage.is128GigStorageOptionSelected());
    }


    @Test(priority = 6)
    public void testSelectPinkColor() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        loginPage.waitForLoginSuccess();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        Assert.assertEquals(practicePage.getSelectedDeviceColor(), "Blue");
    }

    @Test(priority = 7)
    public void testSelectBlueColor() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        Assert.assertEquals(practicePage.getSelectedDeviceColor(), "Blue");
    }

    @Test(priority = 8)
    public void testEnterQuantity() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        Assert.assertEquals(practicePage.getEnteredQuantity(), "2");
        
    }

    @Test(priority = 9)
    public void testEnterAddress() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        Assert.assertEquals(practicePage.getEnteredAddress(), "123 Test Street");
        Assert.assertTrue(practicePage.isAddressTextboxDisplayed());
    }

    @Test(priority = 10)
    public void testClickNextButton() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        Assert.assertTrue(practicePage.isNextButtonDisplayed());
        practicePage.clickNextButton();
        Assert.assertEquals(practicePage.getDeviceSummary(), "Device Summary");
        
    }

    @Test(priority = 11)
    public void testSelectShippingMethod() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        practicePage.clickNextButton();
        Assert.assertEquals(practicePage.getDeviceSummary(), "Device Summary");
        practicePage.selectShippingMethod();
        Assert.assertTrue(practicePage.isShippingMethodSelected());
     }

    @Test(priority = 12)
    public void testSelectWarrantyOption() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        practicePage.clickNextButton();
        practicePage.selectShippingMethod();
        practicePage.selectWarrantyOption();
        Assert.assertTrue(practicePage.isWarrantyOptionSelected());
        
    }

    @Test(priority = 13)
    public void testEnterDiscountCode() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();   
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        practicePage.clickNextButton();
        practicePage.selectShippingMethod();
        practicePage.selectWarrantyOption();
        practicePage.enterDiscountCode("SAVE10");
        practicePage.clickDiscountCodeApplyButton();
        Assert.assertTrue(practicePage.isDiscountCodeApplied());
        Assert.assertEquals(practicePage.getDiscountCodeAppliedText(), "Code SAVE10 applied: -10%");
        Assert.assertEquals(practicePage.getDeviceSummary(), "Device Summary");
     }

    @Test(priority = 14)
    public void testClickConfirmPurchaseButton() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        loginPage.waitForLoginSuccess();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        practicePage.clickNextButton();
        practicePage.selectShippingMethod();
        practicePage.selectWarrantyOption();
        practicePage.enterDiscountCode("SAVE10");
        practicePage.clickDiscountCodeApplyButton();
        practicePage.clickConfirmPurchaseButton();
        Assert.assertTrue(practicePage.isViewInvoiceButtonDisplayed());
        Assert.assertEquals(practicePage.getViewInvoiceButtonText(), "View Invoice");
    }

    @Test(priority = 15)
    public void testClickViewInvoiceButton() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        practicePage.clickNextButton();
        practicePage.selectShippingMethod();
        practicePage.selectWarrantyOption();
        practicePage.enterDiscountCode("SAVE10");
        practicePage.clickDiscountCodeApplyButton();
        practicePage.clickConfirmPurchaseButton();
        Assert.assertTrue(practicePage.isViewInvoiceButtonDisplayed());
        Assert.assertEquals(practicePage.getViewInvoiceButtonText(), "View Invoice");
        practicePage.clickViewInvoiceButton();
        Assert.assertTrue(practicePage.isInvoiceHistoryDisplayed());
    }

    @Test(priority = 16)
    public void testClickViewButton() {
        LoginPage loginPage = new LoginPage(BrowserFactory.driver);
        LandingPage landingPage = new LandingPage(BrowserFactory.driver);
        PracticePage practicePage = new PracticePage(BrowserFactory.driver);
        loginPage.clickLoginMainButton();
        loginPage.enterUsername("info@quality.com");
        loginPage.enterPassword("tA242e1985$");
        loginPage.clickLoginButtonToSubmit();   
        landingPage.clickLandingPageLearnMenuButton();
        landingPage.clickLearningMaterials();
        practicePage.clickWebTabButton();
        practicePage.clickInventoryFromRequirements();
        practicePage.selectIphone();
        practicePage.select128GigStorageOption();
        practicePage.selectBlueColor();
        practicePage.enterQuantity(2);
        practicePage.enterAddress("123 Test Street");
        practicePage.clickNextButton();
        practicePage.selectShippingMethod();
        practicePage.selectWarrantyOption();
        practicePage.enterDiscountCode("SAVE10");
        practicePage.clickDiscountCodeApplyButton();
        practicePage.clickConfirmPurchaseButton();
        practicePage.clickViewInvoiceButton();
        practicePage.clickViewButton();
        Assert.assertTrue(practicePage.isViewButtonDisplayed());
        Assert.assertTrue(practicePage.getViewButtonText().contains("View"));
        Assert.assertTrue(practicePage.isInvoiceHistoryDisplayed());
        Assert.assertTrue(practicePage.getInvoiceHistoryTitle().contains("Invoice History"));
        Assert.assertTrue(practicePage.getInvoiceHistoryText().contains("Invoice History"));
    }

    
}
