package WebAutomationAdvance.tests;

import WebAutomationAdvance.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class InventoryPurchaseTest {

    WebDriver driver;

    @Test
    public void inventoryPurchaseTest() throws Exception {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://ndosisimplifiedautomation.vercel.app/");

        // Create Page Objects
        LoginPage login = new LoginPage(driver);
        DashboardPage dashboard = new DashboardPage(driver);
        InventoryPage inventory = new InventoryPage(driver);
        ExtrasPage extras = new ExtrasPage(driver);
        SuccessPage success = new SuccessPage(driver);
        InvoicePage invoice = new InvoicePage(driver);

        // Login
        login.login(
                "yolandamasiza@gmail.com",
                "Masiza@1988");

        // Navigate
        dashboard.openLearningMaterials();

        // Open form
        inventory.openWebAutomationAdvanced();

        // Complete inventory page
        inventory.completeInventoryForm();

        // Complete extras page
        extras.completeExtrasForm();


        success.clickViewInvoice();

         if(invoice.isInvoicePanelDisplayed()) {
            System.out.println("Invoice panel displayed");
        }

        Thread.sleep(2000);

        invoice.clickViewButton();

    }
}