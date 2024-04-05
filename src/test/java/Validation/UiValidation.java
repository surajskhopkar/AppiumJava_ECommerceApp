package Validation;

import Utils.Configuration;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class UiValidation extends Configuration {

    public String title;
    public void VerifyApp(){

        //title = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getAttribute("text");
        title = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]"))
                        .getAttribute("text");
        Assert.assertEquals(title, "General Store");
    }
}
