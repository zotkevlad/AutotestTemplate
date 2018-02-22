import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SearchPage;
import utils.driver.MyDriverManager;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

@Epic("Allure examples")
@Feature("TestNG + Appium demo")
public class AppiumDemoTest {

    @BeforeClass(description = "Create driver")
    public void setUp() {
        WebDriverRunner.setWebDriver(MyDriverManager.createCustomChromeAppiumDriver("http://127.0.0.1:4723/wd/hub", Thread.currentThread().getStackTrace()[1].getMethodName()));
        com.codeborne.selenide.Configuration.browser = "chrome";
    }


    @Story("Appium demo")
    @Description("Google search test with Appium 1")
    @Test(description = "test1")
    public void searchDemo() {
        open("http://google.com");
        new SearchPage().search("Appium")
                .verifyTestResultContainsString("Appium: Mobile App Automation Made Awesome.");
    }

//    @Story("Test story")
//    @Description("Google search test with Appium 2")
//    @Test(description = "test2")
//    public void searchDemo2() {
//        open("http://google.com");
//        new SearchPage().search("Appium")
//                .verifyTestResultContainsString("Appium: Mobile Aaaasdpp Automation Made Awesome.");
//    }

    @AfterClass(description = "Close driver")
    public void tearDown() {
        close();
    }
}
