//Validate the totol amount generated of the added product

package TestCases;

import Utils.Configuration;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase4 extends Configuration {

    public int productCount = 0;

    @Test
    public void ValidateAmount() throws InterruptedException {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Robert Dwayne");
        driver.hideKeyboard();
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='India']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(5000);

        //Scroll to products and add to cart
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 4 Retro\"))"));
        productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.print(productCount);

        for(int i=0; i<productCount; i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Air Jordan 4 Retro")){
                driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
            }
        }
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
        productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.print(productCount);

        for(int i=0; i<productCount; i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (productName.equalsIgnoreCase("Converse All Star")){
                driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
            }
        }

        Thread.sleep(3000);
        //Navigate to cart
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();


        //wait for Cart page to display
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains
                (driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text", "Cart"));


        //Retrieve product prices
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double sum = 0;

        for(int i=0; i<count; i++){
            String amountPrices = productPrices.get(i).getText();
            Double price = Double.parseDouble(amountPrices.substring(1));
            sum = sum + price;
        }

        String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getAttribute("text");
        Double total = Double.parseDouble(totalAmount.substring(1));

        Assert.assertEquals(sum, total);



    }

}
