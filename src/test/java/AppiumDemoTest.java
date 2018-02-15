//import com.codeborne.selenide.WebDriverRunner;
//
//import io.qameta.allure.Description;
//import io.qameta.allure.Feature;
//import org.junit.Test;
//import pages.SearchPage;
//import utils.driver.MyDriverManager;
//
//import static com.codeborne.selenide.Selenide.close;
//import static com.codeborne.selenide.Selenide.open;
//
//
//public class AppiumDemoTest {
//
//    @Feature("Google search")
//    @Description("Google search test with Appium")
//    @Test
//    public void searchDemo(){
//        WebDriverRunner.setWebDriver(MyDriverManager.createCustomChromeAppiumDriver("INSERT YOUR URL TO APPIUM SERVER HERE", Thread.currentThread().getStackTrace()[1].getMethodName()));
//        com.codeborne.selenide.Configuration.browser = "chrome";
//        open("http://google.com");
//        new SearchPage().search("Appium")
//                .verifyTestResultContainsString("Appium: Mobile App Automation Made Awesome.");
//        close();
//
//    }
//}
