package com.solvd.carina_testing.components;

import com.solvd.carina_testing.pages.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//*[@type='search']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[contains(text(), 'Пошук')]")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//*[@class='mega-brands__inner']")
    private DropDownMenuBrands dropDownMenuBrands;

    @FindBy(xpath = "//span[contains(text(), 'Бренди')]")
    private ExtendedWebElement brandButton;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchInputValue(String value) {
        searchInput.type(value);
    }

    public boolean isSearchInputPresent() {
        return searchInput.isElementPresent();
    }

    public String getSearchInputPlaceholder() {
        return searchInput.getAttribute("placeholder");
    }

    public boolean isSearchButtonPresent() {
        return searchButton.isElementPresent();
    }

    public SearchPage clickSearchButton() {
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public DropDownMenuBrands clickBrands() {
        brandButton.click();
        return dropDownMenuBrands;
    }

    public boolean isBrandButtonPresent() {
        return brandButton.isElementPresent();
    }
}
