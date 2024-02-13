package com.solvd.carina_testing.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductCard extends AbstractUIObject {

    @FindBy(xpath = "//span[@aria-label]")
    private ExtendedWebElement descriptionElement;

    @FindBy(xpath = "//span[@class='product__brand']")
    private ExtendedWebElement titleElement;

    @FindBy(xpath = "//span[contains(text(), 'До кошика')]")
    private ExtendedWebElement addToBagButton;

    public ProductCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getDescriptionText() {
        return descriptionElement.getText();
    }

    public String getTitleText() {
        return titleElement.getText();
    }

    public void addProductToBag() {
        addToBagButton.click();
    }

}
