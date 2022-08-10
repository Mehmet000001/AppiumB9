package intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AppiumIntro {
    @Test
    public  void test1() throws MalformedURLException {
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Mehmet");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());
        desiredCapabilities.setCapability("automationName","uiautomator2");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(serverUrl,desiredCapabilities);
        AndroidElement accessibility=driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']"));
        accessibility.click();
        AndroidElement customView=driver.findElement(By.xpath("//android.widget.TextView[@text='Custom View']"));
        customView.click();

    }
    @Test
    public void  test2() throws MalformedURLException {
        URL serverUrl=new URL("http://localhost:4723/wd/hub");
        File apkFile=new File("src/test/resources/ApiDemos-debug.apk");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName","Mehmet");
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());
        desiredCapabilities.setCapability("automationName","uiautomator2");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(serverUrl,desiredCapabilities);
        AndroidElement views=driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
        views.click();
        AndroidElement Buttons=driver.findElement(By.xpath("//android.widget.TextView[@text='Buttons']"));
        Buttons.click();
//        AndroidElement validatedNormal=driver.findElement(By.id("io.appium.android.apis:id/button_normal"));
//        String normal=validatedNormal.getText();
//        Assert.assertEquals("NORMAL",normal);
//        AndroidElement validatedSmall=driver.findElement(By.id("io.appium.android.apis:id/button_small"));
//        String small=validatedSmall.getText();
//        Assert.assertEquals("SMALL",small);
//        AndroidElement validatedOff=driver.findElement(By.id("io.appium.android.apis:id/button_toggle"));
//        String off=validatedOff.getText();
//        Assert.assertEquals("OFF",off);
        List<AndroidElement> buttonsList=driver.findElements(By.className("android.widget.Button"));
        for (AndroidElement button: buttonsList){
            System.out.println();
        }
        AndroidElement toggleButton=driver.findElement(By.id("io.appium.android.apis:id/button_toggle"));
        Assert.assertEquals("OFF",toggleButton.getText());
        toggleButton.click();
        Assert.assertEquals("ON",toggleButton.getText());


    }
    @Test
    public  void  test3(){
        AndroidDriver<AndroidElement> driver=utils.AppiumUtils.getAndroidDriver();
       AndroidElement contentButton= driver.findElementByAndroidUIAutomator("text(\"Content\")");
       contentButton.click();

    }

}
