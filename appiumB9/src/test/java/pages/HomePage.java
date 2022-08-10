package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumUtils;

public class HomePage {
    public  HomePage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }
    @AndroidBy(id="android:id/text1")
    AndroidElement countriesDropDown;
    @AndroidBy(id="com.androidsample.generalstore:id/nameField")
    AndroidElement nameField;
    @AndroidBy(id="com.androidsample.generalstore:id/radioMale")
    AndroidElement genderMale;
    @AndroidBy(id="com.androidsample.generalstore:id/radioFemale")
    AndroidElement genderFemale;

    public  void fillUpNameField(String name){
        nameField.sendKeys(name);
    }
    public  void selectShoppingCountry(String countryName){
        AndroidElement country= AppiumUtils.getAndroidDriver("General-Store")
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+countryName+"\"))");
        TouchAction touchAction=new TouchAction(AppiumUtils.getAndroidDriver("General-Store"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(country))).perform();
    }


}
