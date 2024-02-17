package com.solvd.carina_testing;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BrowsePage extends AbstractPage {
    public BrowsePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id=\"com.todoist:id/content\"]/*/*/android.widget.Button")
    private ExtendedWebElement settingsButton;

    public void clickSettingsButton(){
        settingsButton.click();
    }
    public boolean isSettingsButtonPresent(){
        return settingsButton.isElementPresent();
    }
}
