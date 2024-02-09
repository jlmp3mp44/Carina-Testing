package com.solvd.carina_testing.components;

import com.solvd.carina_testing.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchLineComponent extends AbstractUIObject {
    @FindBy(xpath = "//*[@type='search']")
    private ExtendedWebElement searchInput;
    @FindBy(xpath = "//*[@class='m-search-bar__action']//*[@class='sf-button m-search-bar__button']")
    private ExtendedWebElement searchButton;
    public SearchLineComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchInputValue(String value){
        searchInput.type(value);
    }

    public ExtendedWebElement getSearchInput() {
        return searchInput;
    }
    public String getSearchInputPlaceholder(){
        return searchInput.getAttribute("placeholder");
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }
    public SearchPage clickSearchButton(){
        searchButton.click();
        return new SearchPage(getDriver());
    }
}
