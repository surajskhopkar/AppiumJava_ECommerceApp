package TestCases;

import Utils.Configuration;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase5 extends Configuration {

    @Test
    public void longPress() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Robert Dwayne");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='India']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(5000);

        //Scroll to product
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.print(productCount);

        for(int i=0; i<productCount; i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
            }
        }

        Thread.sleep(3000);
        //Navigate to cart
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains
                (driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));

        //long press action to read terms of conditions
        longPress(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));

        String termsAndConditions = driver.findElement(By.id("android:id/message")).getText();
        System.out.println(termsAndConditions);
    }
}
