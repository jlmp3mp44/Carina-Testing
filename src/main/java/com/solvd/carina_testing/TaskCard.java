package com.solvd.carina_testing;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TaskCard extends AbstractUIObject {

    public TaskCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//*[@resource-id='com.todoist:id/text' and @text='%s']")
    private ExtendedWebElement createdTaskTitle;

    @FindBy(xpath = ".//*[@content-desc='Complete']")
    private ExtendedWebElement checkBox;

    public boolean isCreatedTaskPresent(String titleTask) {
        return createdTaskTitle.format(titleTask).isElementPresent();
    }

    public boolean isCheckBoxPresent() {
        return checkBox.isElementPresent();
    }

    public void deleteTask() {
        checkBox.click();
    }

}
