package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Configuration {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @Test
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 6 Pro API 34");
        options.setApp("//Users//surajkhopkar//Library//CloudStorage//OneDrive-Personal//Repositories//JavaFrameworks//" +
                       "AppiumJava_ECommerceApp//src//test//java//resources//General-Store.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);

    }




}
