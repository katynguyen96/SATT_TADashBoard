package com.tadashboard.testcases.DA_LOGIN;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.DashBoardPage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC004 extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();
    @Test
    public void TC004_LoginDifferentRepo() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(),"");
        DashBoardPage dashBoardPage = new DashBoardPage();
        Log.info("Log out");
        dashBoardPage.logout();
        Log.info("Select Repo Test");
        loginPage.selectRepo("Test");
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(), "");
        String DBUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(DBUrl.contains("http://localhost/TADashboard/"));
    }
}
