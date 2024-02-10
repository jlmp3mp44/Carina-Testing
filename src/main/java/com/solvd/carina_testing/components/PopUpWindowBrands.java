package com.solvd.carina_testing.components;

import com.solvd.carina_testing.pages.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PopUpWindowBrands extends AbstractUIObject {

    @FindBy(xpath = "//*[contains(@class, 'sf-link')]")
    private List<ExtendedWebElement> brandTitles;

    public PopUpWindowBrands(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchPage clickBrandTitle(String title) {
        for (ExtendedWebElement element : brandTitles) {
            if (element.getText().contains(title)){//&& element.getAttribute("title").equals(title)) {
                element.click();
                return new SearchPage(getDriver());
            }
        }
        return null;
    }

    public List<ExtendedWebElement> getBrandTitles() {
        return brandTitles;
    }
}
