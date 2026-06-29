package utils;

import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;

public class Base {

    public void setup() {
        BrowserFactory.startBrowser("chrome");
    }

    public void tearDown() {
        BrowserFactory.quitBrowser();

    }

    public LoginPage loginPage = PageFactory.initElements(BrowserFactory.driver, LoginPage.class);
}
