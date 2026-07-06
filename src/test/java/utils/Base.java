package utils;

import org.openqa.selenium.support.PageFactory;

import pages.LandingPage;
import pages.LoginPage;

public class Base {

    public void setup() {
        BrowserFactory.startBrowser("chrome");
    }

    public void tearDown() {
        BrowserFactory.quitBrowser();

    }

    public LoginPage loginPage = PageFactory.initElements(BrowserFactory.driver, LoginPage.class);
    public LandingPage landingPage = PageFactory.initElements(BrowserFactory.driver, LandingPage.class);
}
