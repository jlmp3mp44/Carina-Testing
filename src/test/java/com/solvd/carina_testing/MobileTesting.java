package com.solvd.carina_testing;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MobileTesting extends AbstractTest implements IMobileUtils {

    private static final String TITLE_TASK = "Go to the shop";
    private static final  int INDEX_TASK = 2;

    @Test
    public void verifyCreatingTask(){
        TodayPage todayPage =  new TodayPage(getDriver());
        startApp("com.todoist");
        int numOfTasksBeforeAddNew = todayPage.getTaskCards().size();
        todayPage.addNewTask();
        Assert.assertTrue(todayPage.isAirplaneButtonPresent(), "Airplane button isn`t present!");
        todayPage.createNewTask(TITLE_TASK);
        int numOfTasksAfterAddNew = todayPage.getTaskCards().size();
        System.out.println(numOfTasksBeforeAddNew + " " + numOfTasksAfterAddNew);
        Assert.assertTrue(numOfTasksAfterAddNew > numOfTasksBeforeAddNew, "New task was not added");
    }

    @Test
    public void verifyDeleteTask(){
        TodayPage todayPage = new TodayPage(getDriver());
        startApp("com.todoist");
        int numOfTasksBeforeDelete = todayPage.getTaskCards().size();
        todayPage.getTaskCards().get(2).deleteTask(2);
        int numOfTasksAfterDelete = todayPage.getTaskCards().size();
        Assert.assertTrue(numOfTasksAfterDelete < numOfTasksBeforeDelete, "Task was not deleted");
    }

}
