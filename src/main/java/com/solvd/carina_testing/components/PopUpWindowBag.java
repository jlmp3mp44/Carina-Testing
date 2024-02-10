package com.solvd.carina_testing.components;

import com.solvd.carina_testing.pages.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PopUpWindowBag extends AbstractUIObject {

    @FindBy(xpath = "//button[contains(text(), 'Зробити замовлення')]")
    private ExtendedWebElement buttonCreateOrder;
    public PopUpWindowBag(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getButtonCreateOrder() {
        return buttonCreateOrder;
    }
    public CheckoutPage createOrder(){
        buttonCreateOrder.click();
        return new CheckoutPage(getDriver());
    }
}
