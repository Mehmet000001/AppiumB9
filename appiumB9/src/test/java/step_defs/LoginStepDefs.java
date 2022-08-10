package step_defs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utils.AppiumUtils;

import java.util.List;

public class LoginStepDefs {
AndroidDriver<AndroidElement> driver;
    @Given("ecommerce app has launched")
    public void ecommerce_app_has_launched() {
     driver= AppiumUtils.getAndroidDriver("General-Store");
    }
    @When("I login to shop in Afghanistan")
    public void i_login_to_shop_in_afghanistan() {
        driver.findElementById("android:id/text1").click();
        AndroidElement country = driver
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Albania\"))");
        country.click();
        AndroidElement nameField=driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        nameField.sendKeys("Mehmet");
        AndroidElement lestShopButton=driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
        lestShopButton.click();
    }
    @Then("I should see list o items")
    public void i_should_see_list_o_items() {
        List<AndroidElement> itemsList=driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.RelativeLayout"));
//        for (int i=0;i<itemsList.size();i++){
//            System.out.println(itemsList.get(i).getText());
//        }
        itemsList.forEach(item->System.out.println(item.getAttribute("text")));

    }

}
