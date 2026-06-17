package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

  public static WebDriver driver;

    public static void startBrowser(String browserType, String url){

        if (browserType.equalsIgnoreCase( "ChRome" ));{
            ChromeOptions options = new ChromeOptions();
            options.addArguments( "--incognito" );
            driver = new ChromeDriver();

        } else if (browserType.equalsIgnoreCase( "FireFox" ));{
            driver = new FirefoxDriver();

        } else if(browserType.equalsIgnoreCase( "Safari" ));{
             driver = new SafariDriver();

        } else {
            driver = new EdgeDriver();
        }

        driver.get(url);
        driver.manage().window().maximize();

        return driver;

    }

}
