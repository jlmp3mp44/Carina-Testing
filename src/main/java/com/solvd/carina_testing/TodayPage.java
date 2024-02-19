package com.solvd.carina_testing;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodayPage extends AbstractPage implements IMobileUtils {

    @FindBy(xpath = "//*[@content-desc='Quick add']")
    private ExtendedWebElement addTaskButton;

    @FindBy(xpath = "(//*[@text='Today'])[1]")
    private ExtendedWebElement titleToday;

    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    private ExtendedWebElement inputTitleTaskLine;

    @FindBy(xpath = "//*[@content-desc='Add']")
    private ExtendedWebElement airplaneButton;

    @FindBy(xpath = "(//*[@resource-id='com.todoist:id/item'])")
    private List<TaskCard> taskCards;

    @FindBy(xpath = "//*[@resource-id='com.todoist:id/compose_navigation_holder']")
    private Footer footer;

    public TodayPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddTaskButton() {
        addTaskButton.click();
    }

    public boolean isTodayPageOpened() {
        return titleToday.isElementPresent();
    }

    public void createNewTask(String titleTask) {
        inputTitleTaskLine.click();
        inputTitleTaskLine.type(titleTask);
        airplaneButton.click();
        hideKeyboard();
    }

    public boolean isAirplaneButtonPresent() {
        return airplaneButton.isElementPresent();
    }

    public List<TaskCard> getTaskCards() {
        return taskCards;
    }

    public Footer getFooter() {
        return footer;
    }

    public boolean isListOfTasksPresent() {
        return !taskCards.isEmpty();
    }

    public boolean isFooterPresent() {
        return footer.isUIObjectPresent();
    }

}
