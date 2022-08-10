package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumUtils {
    static AndroidDriver<AndroidElement> driver;

    public static AndroidDriver<AndroidElement> getAndroidDriver() {
        URL serverUrl;
        try {
            serverUrl = new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }


        File apkFile = new File("src/test/resources/ApiDemos-debug.apk");


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability("deviceName", "Dima");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        desiredCapabilities.setCapability("automationName", "uiautomator2");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);
        return driver;
    }

    public static AndroidDriver<AndroidElement> getAndroidDriver(String appName) {
        if (driver == null) {
            URL serverUrl;
            try {
                serverUrl = new URL("http://localhost:4723/wd/hub");
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }


            File apkFile = new File("src/test/resources/" + appName + ".apk");


            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            desiredCapabilities.setCapability("deviceName", "Dima");
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
            desiredCapabilities.setCapability("automationName", "uiautomator2");

            driver = new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;

    }
    }
