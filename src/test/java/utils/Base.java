package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;
import pages.InventoryFormPage;
import pages.LandingPage;
import pages.LoginPage;

//works with the BrowserFactory and calls all the pages

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    public final WebDriver driver = browserFactory.startBrowser("chrome","https://ndosisimplifiedautomation.vercel.app/");
    public ContactUsPage contactUsPage = PageFactory.initElements(driver, ContactUsPage.class);
    public LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public InventoryFormPage InventoryPage = PageFactory.initElements(driver, InventoryFormPage.class);

}
