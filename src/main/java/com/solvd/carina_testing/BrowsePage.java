package com.solvd.carina_testing;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BrowsePage extends AbstractPage {
    public BrowsePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.todoist:id/content']/*/*/android.widget.Button")
    private ExtendedWebElement settingsButton;

    @FindBy(xpath = "//*[@resource-id='com.todoist:id/recycler_view']/*/android.widget.RelativeLayout")
    private List<ExtendedWebElement> settingsList;

    @FindBy(xpath = "//*[contains(@text, 'Home')]")
    private ExtendedWebElement homeProjectButton;

    @FindBy(xpath = "(//*[@resource-id='com.todoist:id/item'])")
    private List<TaskCard> taskCards;

    public void clickSettingsButton(){
        settingsButton.click();
    }
    public boolean isSettingsButtonPresent(){
        return settingsButton.isElementPresent();
    }
    public boolean isSettingsListNotEmpty(){
        return !settingsList.isEmpty();
    }
    public boolean isHomeProjectButtonPresent(){
        return homeProjectButton.isElementPresent();
    }

    public void clickHomeProjectButton(){
        homeProjectButton.click();
    }
    public boolean isTaskCardListNotEmpty(){
        return !taskCards.isEmpty();
    }

}
