package com.tadashboard.testcases.DA_MP;

import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.DashBoardPage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.pageObjects.TADashBoard.PagePopup;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC019 extends BaseTestSetUp {
    @Test(description = "Verify that user is able to add additional sibling page levels to the parent page successfully")
    public void TC019_AddAdditionalSiblingPage() {
        ConfigFileReader configFileReader = new ConfigFileReader();
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(), "");
        PagePopup pagePopup = new PagePopup();
        Log.info("Go to Global Setting -> Add page");
        DashBoardPage dashBoardPage = new DashBoardPage();
        Log.info("Open Add page popup");
        dashBoardPage.openAddPagePopup();
        Log.info("Enter info into all required fields on New Page dialog");
        pagePopup.addPage("Page 1", "Overview");
        pagePopup.waitPopupDisapear();
        Assert.assertTrue(dashBoardPage.isPageChildrenDisplay("Page 1"));
    }
}

