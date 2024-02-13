package com.solvd.carina_testing.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TrackOrderPage extends AbstractPage {

    @FindBy(xpath = "//input[@placeholder='Введіть номер замовлення']")
    private ExtendedWebElement inputOrderNumberLine;

    @FindBy(xpath = "//button[contains(text(), 'Відстежити замовлення')]")
    private ExtendedWebElement trackOrderButton ;

    @FindBy(xpath = "//*[contains(text(), 'Замовлення не знайдено')]")
    private ExtendedWebElement orderDidntFoundTitle;
    public TrackOrderPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(inputOrderNumberLine);
    }
    public boolean isInputOrderNumberlinePresent(){
        return inputOrderNumberLine.isElementPresent();
    }
    public void typeInputOrderNumber(String number){
        inputOrderNumberLine.type(number);
    }
    public boolean isTrackOrderButtonPresent(){
        return trackOrderButton.isElementPresent();
    }
    public void clickTrackOrderButton(){
        trackOrderButton.click();
    }
    public boolean isOrderDidntFoundTitlePresent(){
        return orderDidntFoundTitle.isElementPresent();
    }

}
