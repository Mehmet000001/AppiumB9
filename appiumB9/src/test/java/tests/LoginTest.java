package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import pages.HomePage;
import utils.AppiumUtils;

public class LoginTest {
    @Test
    public  void happyPathLoginTest(){
        AndroidDriver<AndroidElement> driver= AppiumUtils.getAndroidDriver("General-Store");
        HomePage homePage=new HomePage(driver);
        homePage.selectShoppingCountry("Italy");
        homePage.fillUpNameField("Mehmet");
    }
}
