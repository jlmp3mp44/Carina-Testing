package com.solvd.carina_testing;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "(//*[@text='Search'])[1]")
    private ExtendedWebElement searchTitle;

    @FindBy(xpath = "//*[@resource-id='com.todoist:id/content' and @text='Today']")
    private ExtendedWebElement todayTasksButton;

    public boolean isSearchPageOpened(){
        return searchTitle.isElementPresent();
    }

    public TodayPage clickTodayTaskButton(){
        todayTasksButton.click();
        return new TodayPage(getDriver());
    }

}
