//Verify Toast Error Message

package TestCases;

import Utils.Configuration;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase2 extends Configuration {

    @Test
    public void VerifyErrorMessage(){

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String Error_Message = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("text");
        Assert.assertEquals(Error_Message,"Please enter your name");
        System.out.println(Error_Message);
    }
}
