package com.solvd.carina_testing.components;

import com.solvd.carina_testing.pages.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {
    @FindBy(xpath = "//*[@data-v-f0f2c96e]//*[@class='m-search-bar__wrapper']//*[@type='search']")
    private ExtendedWebElement searchInput;
    @FindBy(xpath = "//*[@data-v-f0f2c96e]//*[@class='m-search-bar__wrapper']//button[contains(text(), 'Пошук')]")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//*[@class='nav-horizontal']//*[@class='mega-brands__inner']")
    private PopUpWindowBrands popUpWindowBrands;
    @FindBy(xpath = "//*[@class='nav-horizontal']//span[contains(text(), 'Бренди')]")
    private ExtendedWebElement brands;
    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeSearchInputValue(String value){
        searchInput.type(value);
    }

    public boolean isSearchInputPresent() {
        return searchInput.isElementPresent();
    }
    public String getSearchInputPlaceholder(){
        return searchInput.getAttribute("placeholder");
    }

    public boolean isSearchButtonPresent() {
        return searchButton.isElementPresent();
    }
    public SearchPage clickSearchButton(){
        searchButton.click();
        return new SearchPage(getDriver());
    }
    public PopUpWindowBrands clickBrands(){
        brands.click();
        return getPopUpWindowBrands();
    }
    public PopUpWindowBrands getPopUpWindowBrands() {
        return popUpWindowBrands;
    }

    public boolean isBrandsPresent() {
        return brands.isElementPresent();
    }
}
