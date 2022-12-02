package com.tadashboard.testcases.DA_DP;

import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.pageObjects.TADashBoard.ProfilePage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC093 extends BaseTestSetUp {
    ConfigFileReader configFileReader =  new ConfigFileReader();
    @Test(description = "Verify that user is able to remove filter criteria successfully")
    public void TC093_RemoveFilterCriteria() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(), "");
        ProfilePage profilePage = new ProfilePage();
        Log.info("Go to filter field");
        profilePage.goToFilterField("test");
        Log.info("Add new filter");
        profilePage.addNewFilter();
        Log.info("Remove filter");
        profilePage.removeFilter();
        Assert.assertFalse(profilePage.isFilterDisplayed());
    }
}
