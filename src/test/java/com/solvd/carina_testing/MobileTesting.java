package com.solvd.carina_testing;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MobileTesting extends AbstractTest implements IMobileUtils {

    private static final String TITLE_TASK = "Go to the gym";
    private static final  int INDEX_TASK = 2;

    @Test
    public void verifyCreatingTask(){
        TodayPage todayPage =  new TodayPage(getDriver());
        int numOfTasksBeforeAddNew = todayPage.getTaskCards().size();
        todayPage.clickOnAddTaskButton();
        Assert.assertTrue(todayPage.isAirplaneButtonPresent(), "Airplane button isn`t present!");
        Assert.assertTrue(todayPage.isHideKeyboardPresent());
        todayPage.createNewTask(TITLE_TASK);
        int numOfTasksAfterAddNew = todayPage.getTaskCards().size();
        Assert.assertTrue(numOfTasksAfterAddNew > numOfTasksBeforeAddNew, "New task was not added");
    }

    @Test
    public void verifyDeleteTask(){
        TodayPage todayPage = new TodayPage(getDriver());
        int numOfTasksBeforeDelete = todayPage.getTaskCards().size();
        Assert.assertTrue(todayPage.getTaskCards().get(2).isCheckBoxPresent());
        todayPage.getTaskCards().get(2).deleteTask(2);
        int numOfTasksAfterDelete = todayPage.getTaskCards().size();
        Assert.assertTrue(numOfTasksAfterDelete < numOfTasksBeforeDelete, "Task was not deleted");
    }

    @Test
    public void verifySearchPage(){
        TodayPage todayPage =  new TodayPage(getDriver());
        Assert.assertTrue(todayPage.isTodayPageOpened(), "Today page is not opened!");
        Assert.assertTrue(todayPage.isFooterPresent(), "Footer is not present!");
        Assert.assertTrue(todayPage.getFooter().isSearchPageButtonPresent(), "Search page button is not present!");
        SearchPage searchPage = todayPage.getFooter().clickSearchPageButton();
        Assert.assertTrue(searchPage.isSearchPageOpened(), "Search page is not opened!");
        todayPage = searchPage.clickTodayTaskButton();
        Assert.assertTrue(todayPage.isTodayPageOpened(), "Today page was not opened");
        Assert.assertTrue(todayPage.isListOfTasksPresent(), "List of tasks is not present");
    }

    @Test
    public void verifySettings(){
        TodayPage todayPage =  new TodayPage(getDriver());
        Assert.assertTrue(todayPage.isTodayPageOpened(), "Today page is not opened!");
        Assert.assertTrue(todayPage.isFooterPresent(), "Footer is not present!");
        Assert.assertTrue(todayPage.getFooter().isBrowsePageButtonPresent(), "Browse page button is not present!");
        BrowsePage browsePage = todayPage.getFooter().clickOnBrowsePageButton();
        Assert.assertTrue(browsePage.isSettingsButtonPresent(), "Settings button is nor present");
        browsePage.clickSettingsButton();
    }

    @BeforeMethod
    public void beginOfApp(){
        startApp("com.todoist");
    }

}
