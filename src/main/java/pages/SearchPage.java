package pages;

import com.codeborne.selenide.conditions.Text;
import elements.impl.Search;
import elements.interfaces.ISearch;
import io.qameta.allure.Step;

public class SearchPage {

    private ISearch search = new Search();

    @Step("Search {query}")
    public SearchPage search(String query) {
        search.getFieldSearch().sendKeys(query);
        search.getFieldSearch().pressEnter();

        return this;
    }

    @Step("Verify test results contains {resultQuery}")
    public SearchPage verifyTestResultContainsString(String resultQuery) {
        search.getBlockSearchResult().shouldHave(new Text(resultQuery));
        return this;
    }
}
