package com.solvd.carina_testing.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//*[@data-v-f0f2c96e]//*[@class='m-search-bar__wrapper']")
    private SearchLineComponent searchLineComponent;
    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchLineComponent getSearchLineComponent() {
        return searchLineComponent;
    }
}
