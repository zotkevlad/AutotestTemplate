package utils.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class MyDriverManager {


    private static boolean isDriverInit = false;
    private static boolean debugMode = false;
    private static DesiredCapabilities capabilities = new DesiredCapabilities();


    public static void init() {
        if (!isDriverInit) {
            ChromeDriverManager.getInstance().setup();
            isDriverInit = true;
        }
    }

    /***
     Create Chrome remote driver to run on Selenoid with VNC

     @return RemoteWebdriver

     ***/
    public static WebDriver createCustomChromeRemoteDriver(String remoteURL, String testName) {
        init();
        com.codeborne.selenide.Configuration.browser = "chrome";
        capabilities.setCapability("enableVNC", true);
        capabilities.setBrowserName("chrome");
        capabilities.setCapability("name", testName);
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create(remoteURL).toURL(), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }


    /***
     Create Android driver to run on Appium

     @return AndroidDriver

     Params are temporary hardcoded

     ***/
    public static WebDriver createCustomChromeAppiumDriver(String remoteURL, String testName) {
        init();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
        capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//        capabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
        WebDriver driver = null;
        try {
            driver = new AndroidDriver<>(
                    URI.create(remoteURL).toURL(), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;

    }


}
