package com.tadashboard.testcases.DA_MP;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.DashBoardPage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC024 extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test(description = "Verify that 'Bread Crums' navigation is correct")
    public void TC024() {
        LoginPage loginPage = new LoginPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(), "");
        dashBoardPage.navigateAddPage();
        dashBoardPage.fillInfoNewPage("Page 1", "Overview", "");
        dashBoardPage.fillInfoNewPage("Page 2", "Overview", "Page 1");
        dashBoardPage.navigateBreadcrum("Page 1");

        Assert.assertEquals(DriverManager.getTitle(), "TestArchitect ™ - Page 1");
    }
}
