package com.solvd.carina_testing.components;

import com.solvd.carina_testing.pages.SearchPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PropositionLine extends AbstractUIObject {

    @FindBy(xpath = "//*[@class='nav-horizontal__el nav-horizontal__el--brands nav-horizontal__el--open']//*[@class='mega-brands__inner']")
    private PopUpWindowBrands popUpWindowBrands;

    @FindBy(xpath = "//*[@class='nav-horizontal__el nav-horizontal__el--brands']")
    private ExtendedWebElement brands;

    public PropositionLine(WebDriver driver, SearchContext searchContext) {

        super(driver, searchContext);
    }
    public PopUpWindowBrands clickBrands(){
            brands.click();
            return getPopUpWindowBrands();
    }

    public PopUpWindowBrands getPopUpWindowBrands() {
        return popUpWindowBrands;
    }

    public ExtendedWebElement getBrands() {
        return brands;
    }
}
