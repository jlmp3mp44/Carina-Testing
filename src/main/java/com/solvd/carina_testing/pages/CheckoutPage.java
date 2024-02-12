package com.solvd.carina_testing.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(xpath = "//h3[contains(text(), 'Оформлення замовлення')]")
    private ExtendedWebElement createOrderLine;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(createOrderLine);
    }
}
