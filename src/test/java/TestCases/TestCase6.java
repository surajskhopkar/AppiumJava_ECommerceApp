package TestCases;

import Utils.Configuration;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class TestCase6 extends Configuration {

    @Test
    public void hybrid() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Robert Dwayne");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Afghanistan\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Afghanistan']")).click();
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

        driver.findElement(By.id("android:id/button1")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("android.widget.CheckBox")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(10000);

        //Handling browser
        Set<String> contexts = driver.getContextHandles();
        for(String context: contexts){
            System.out.println((context));
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        //appium --allow-insecure chromedriver_autodownload
        driver.findElement(By.name("q")).sendKeys("Automation Testing");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");

    }
}
