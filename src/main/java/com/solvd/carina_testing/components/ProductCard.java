package com.solvd.carina_testing.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = "//span[@aria-label]")
    private ExtendedWebElement descriptionElement;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getDescriptionElement() {
        return descriptionElement;
    }
    public String getDescriptionText(){
        return descriptionElement.getText();
    }
}
