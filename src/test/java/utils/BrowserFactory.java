package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
    public static WebDriver driver;

    public static WebDriver startBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.out.println("Firefox browser is not supported");
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.out.println("Edge browser is not supported");
        } else {
            System.out.println("Browser is not supported");
        }

        driver.get("https://ndosisimplifiedautomation.vercel.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void quitBrowser() {
        driver.quit();
    }
}
