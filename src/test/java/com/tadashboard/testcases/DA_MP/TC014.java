package com.tadashboard.testcases.DA_MP;

import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.DashBoardPage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.annotations.Test;

public class TC014 extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test(description = "Verify that 'Public' pages can be visible and accessed by all users of working repository")
    public void TC014() {
        LoginPage loginPage = new LoginPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(),"");
        dashBoardPage.navigateAddPage();
        dashBoardPage.fillInfoNewPage("Railway","Railway" , "");
        dashBoardPage.logout();
        loginPage.login(configFileReader.getUsername(),"");
    }
}

