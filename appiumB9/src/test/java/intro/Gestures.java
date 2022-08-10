package intro;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import utils.AppiumUtils;

import java.time.Duration;

public class Gestures {
    @Test
    public  void scrollTest(){
        AndroidDriver<AndroidElement> driver= AppiumUtils.getAndroidDriver();
         AndroidElement viewsButton=driver.findElementByAndroidUIAutomator("text(\"Views\")");
        viewsButton.click();
       AndroidElement scrollBarsButton=
               driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ScrollBars\"))");
       scrollBarsButton.click();
    }
    @Test
    public void tapTest(){
        AndroidDriver<AndroidElement> driver=AppiumUtils.getAndroidDriver();
        TouchAction touchAction=new TouchAction(driver);
        AndroidElement viewsButton=driver.findElementByAndroidUIAutomator("text(\"Views\")");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();
    }
    @Test
    public  void  longPressTest(){
        AndroidDriver<AndroidElement> driver=AppiumUtils.getAndroidDriver();
        AndroidElement viewsButton=driver.findElementByAccessibilityId("Views");
        TouchAction touchAction=new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();
        AndroidElement expandableListsButton=driver.findElementByAccessibilityId("Expandable Lists");
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableListsButton))).perform();
       AndroidElement customAdapterButton= driver.findElementByAndroidUIAutomator("text(\"1. Custom Adapter\")");
       touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdapterButton))).perform();
       AndroidElement peopleNamesButton=driver.findElementByAndroidUIAutomator("text(\"People Names\")");
       touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(peopleNamesButton))
               .withDuration(Duration.ofSeconds(2))).perform();


    }
}
