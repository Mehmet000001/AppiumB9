package intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileBrowser {
    @Test
    public void test1() throws MalformedURLException {
        URL severUrl=new URL("http://localhost:4723/wd/hub");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Mehmet");
        desiredCapabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,"uiautomator2");
        desiredCapabilities.setBrowserName("Chrome");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(severUrl,desiredCapabilities);
        driver.get("https://techtorialacademy.com/");
    }
}
