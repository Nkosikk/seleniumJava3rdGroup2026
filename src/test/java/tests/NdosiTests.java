package tests;

import org.testng.annotations.Test;
import utils.Base;

public class NdosiTests extends Base {

    @Test
    public void contactUsTest() {
      contactUsPage.clickContactUsButton();
        contactUsPage.contactMethodsText();
    }



}
