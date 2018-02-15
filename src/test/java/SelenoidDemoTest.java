import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.driver.MyDriverManager;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

@Title("Selenoid demo test")
public class SelenoidDemoTest {

    @Features("Google search")
    @Title("Google search test with Selenoid")
    @Test
    public void searchDemo(){
        WebDriverRunner.setWebDriver(MyDriverManager.createCustomChromeRemoteDriver("INSERT YOUR URL TO SELENOID HUB HERE", Thread.currentThread().getStackTrace()[1].getMethodName()));
        com.codeborne.selenide.Configuration.browser = "chrome";
        open("http://google.com");
        new SearchPage().search("Selenoid")
                .verifyTestResultContainsString("GitHub - aerokube/selenoid");
        close();

    }

}
