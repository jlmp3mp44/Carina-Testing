package com.solvd.carina_testing;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {
    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "/./*[3]/*[2]")
    private ExtendedWebElement searchPageButton;

    @FindBy(xpath = "/./*[4]/*[1]")
    private ExtendedWebElement browsePageButton;

    public boolean isSearchPageButtonPresent(){
        return searchPageButton.isElementPresent();
    }

    public SearchPage clickSearchPageButton(){
        searchPageButton.click();
        return new SearchPage(getDriver());
    }

    public boolean isBrowsePageButtonPresent(){
        return browsePageButton.isElementPresent();
    }

    public BrowsePage clickOnBrowsePageButton(){
        browsePageButton.click();
        return new BrowsePage(getDriver());
    }


}
