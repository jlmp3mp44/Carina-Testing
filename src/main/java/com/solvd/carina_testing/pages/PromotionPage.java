package com.solvd.carina_testing.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PromotionPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(@class, 'title')]")
    private ExtendedWebElement promotionTitle;

    public PromotionPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(promotionTitle);
    }
}
