package com.solvd.carina_testing.components;

import com.solvd.carina_testing.pages.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DropDownMenuBrands extends AbstractUIObject {

    @FindBy(xpath = "//*[contains(text(), 'Популярні бренди') and contains(@class, 'title')]/..//a[contains(text(), '%s')]")
    private ExtendedWebElement brandTitle;

    public DropDownMenuBrands(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchPage clickBrandTitle(String title) {
        brandTitle.format(title).click();
        return new SearchPage(getDriver());
    }

}
