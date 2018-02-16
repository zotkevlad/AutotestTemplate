import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
//import org.junit.Test;
import org.junit.Test;
import pages.SearchPage;
import utils.driver.MyDriverManager;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static utils.driver.MyDriverManager.init;

@DisplayName("Google search test")
public class SelenoidDemoTest {

//    @Feature("Google search")
    @Description("Google search test with Selenoid")
    @Test
    public void searchDemo(){
//        WebDriverRunner.setWebDriver(MyDriverManager.createCustomChromeRemoteDriver("http://autotests.stagingentitledto.co.uk:4444/wd/hub", Thread.currentThread().getStackTrace()[1].getMethodName()));
        init();
        com.codeborne.selenide.Configuration.browser = "chrome";
        open("http://google.com");
        new SearchPage().search("Selenoid");
//                .verifyTestResultContainsString("GitHub - aerokube/selenoid");
//        close();

    }

}
