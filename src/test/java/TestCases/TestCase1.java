//Fill details and verify error message for incorrect details

package TestCases;

import Utils.Configuration;
import Validation.UiValidation;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCase1 extends Configuration {

    UiValidation validation = new UiValidation();

    @Test
    public void FillForm(){

        //validation.VerifyApp();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Robert Dwayne");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));




    }
}
