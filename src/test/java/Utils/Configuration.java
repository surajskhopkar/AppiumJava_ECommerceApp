package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Configuration {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException, InterruptedException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6 Pro API 34");
        options.setApp("//Users//surajkhopkar//Library//CloudStorage//OneDrive-Personal//Repositories//JavaFrameworks//" +
                       "AppiumJava_ECommerceApp//src//test//java//resources//General-Store.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(15000);

    }

    @AfterClass
    public void TearDown(){
        driver.quit();
        service.stop();
    }

    public void longPress(WebElement ele){
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId()
        ));
    }
}
