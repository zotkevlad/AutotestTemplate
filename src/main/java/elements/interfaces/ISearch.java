package elements.interfaces;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public interface ISearch<T> extends ICheckAllElements<T> {

    SelenideElement getFieldSearch();
    SelenideElement getBlockSearchResult();
    ElementsCollection getListSearchResults();

}
