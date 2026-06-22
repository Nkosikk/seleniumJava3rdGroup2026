package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    WebDriver driver;

    By ContactUs_xpath= By.xpath( "//button[@class='nav-item']/span[contains(text(),'Contact Us')]");
    public ContactUsPage(WebDriver driver){
      this.driver = driver;
    }

    public void clickContactUsbutton(){
        driver.findElement(ContactUs_xpath).click();
    }
}

