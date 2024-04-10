//Scroll to the particular product, add to cart and verify if the product is added in the cart

package TestCases;
import Utils.Configuration;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class TestCase3 extends Configuration {

    public void AddProduct() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Robert Dwayne");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='India']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));


    }

}
