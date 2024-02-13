package com.solvd.carina_testing.pages;

import com.solvd.carina_testing.components.ProductCard;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class, 'products__product-card')]")
    private List<ProductCard> cards;

    @FindBy(xpath = "//*[@id='sfSelect']")
    private ExtendedWebElement sortButton;

    public SearchPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(sortButton);
    }

    public List<ProductCard> getCards() {
        return cards;
    }
}
