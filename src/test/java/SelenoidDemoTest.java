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

import static com.codeborne.selenide.Selenide.*;

@Epic("Allure examples")
@Feature("TestNG + Selenoid demo")
public class SelenoidDemoTest {

    @BeforeClass(description = "Create driver")
    public void setUp() {
        WebDriverRunner.setWebDriver(MyDriverManager.createCustomChromeRemoteDriver("http://autotests.stagingentitledto.co.uk:4444/wd/hub", Thread.currentThread().getStackTrace()[1].getMethodName()));
        com.codeborne.selenide.Configuration.browser = "chrome";
    }


    @Story("Appium demo")
    @Description("Google search test with Selenoid 1")
    @Test(description = "test1")
    public void searchDemo() {

        open("http://google.com");
        new SearchPage().search("Selenoid")
                .verifyTestResultContainsString("GitHub - aerokube/selenoid");
        screenshot("theEndOfTest");
        close();
    }

    @AfterClass(description = "Close driver")
    public void tearDown() {
        close();
    }


}
