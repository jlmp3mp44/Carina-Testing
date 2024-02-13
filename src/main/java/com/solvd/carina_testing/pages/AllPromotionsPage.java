package com.solvd.carina_testing.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AllPromotionsPage extends AbstractPage {

    @FindBy(xpath = "//h1[contains(text(), 'Діючі акції на сайті та в магазинах')]")
    private ExtendedWebElement titleAllPromotions;

    @FindBy(xpath = "//span[contains(text(), '%s')]")
    private ExtendedWebElement promotionCard;
    public AllPromotionsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(titleAllPromotions);
    }

    public PromotionPage clickOnThePromotion(String title){
        promotionCard.format(title).click();
        return new PromotionPage(getDriver());
    }

}
