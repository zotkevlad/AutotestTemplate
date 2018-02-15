package elements.impl;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import elements.interfaces.ISearch;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class Search implements ISearch<Search> {

    private final SelenideElement fieldSearch;
    private final SelenideElement blockSearchResult;
    private final ElementsCollection listSearchResults;

    public Search() {
        fieldSearch = $("#lst-ib");
        blockSearchResult = $("#ires");
        listSearchResults = $$(".g .rc .r");
    }


    @Override
    public Search checkAllElements() {
        return null;
    }


}
