package com.tadashboard.testcases.DA_DP;

import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.pageObjects.TADashBoard.ProfilePage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TC073 extends BaseTestSetUp {
    @Test(description = "Verify that all data profile types are listed in priority order under 'Item Type' dropped down menu")
    public void TC073_CheckItemTypesSelect() {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login("test", "test");
        ProfilePage profilePage = new ProfilePage();
        profilePage.checkItemTypes();
        String[] list = {"Test Modules", "Test Cases", "Test Objectives", "Data Sets", "Actions", "Interface Entities", "Test Results", "Test Case Results", "Test Suites", "Bugs"};
        Assert.assertEquals(profilePage.checkItemTypes(), Arrays.stream(list).collect(Collectors.toList()));
    }
}
