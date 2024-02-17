package com.solvd.carina_testing;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodayPage extends AbstractPage {

    @FindBy(xpath = "//*[@content-desc=\"Quick add\"]\n")
    private ExtendedWebElement addTaskButton;

    @FindBy(xpath = "(//*[@text=\"Today\"])[1]")
    private ExtendedWebElement titleToday;

    @FindBy(xpath = "//*[@resource-id=\"android:id/message\"]")
    private ExtendedWebElement inputTitleTaskLine;

    @FindBy(xpath = "//*[@content-desc=\"Add\"]")
    private ExtendedWebElement airplaneButton;

    @FindBy(xpath = "(//*[@resource-id=\"com.todoist:id/item\"])")
    private List<TaskCard> taskCards;
    public TodayPage(WebDriver driver) {
        super(driver);
    }

    public void addNewTask(){
        addTaskButton.click();
    }

    public boolean isTitleTodayPresent(){
        return titleToday.isElementPresent();
    }
    public void createNewTask(String titleTask){
        inputTitleTaskLine.type(titleTask);
        airplaneButton.click();
    }

    public boolean isAirplaneButtonPresent(){
        return airplaneButton.isElementPresent();
    }

    public List<TaskCard> getTaskCards() {
        return taskCards;
    }
}
