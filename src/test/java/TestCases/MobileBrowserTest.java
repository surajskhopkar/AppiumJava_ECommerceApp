package TestCases;

import Utils.BrowserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserConfiguration {

    @Test
    public void BrowserTest() throws InterruptedException {

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("a[routerlink='/products']")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
        String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Assert.assertEquals(text, "Devops");




    }
}
