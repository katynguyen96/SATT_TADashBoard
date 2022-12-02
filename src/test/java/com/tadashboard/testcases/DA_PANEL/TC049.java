package com.tadashboard.testcases.DA_PANEL;

import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.DashBoardPage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.pageObjects.TADashBoard.PagePopup;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC049 extends BaseTestSetUp {
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Test(description = "Verify that all folder paths of corresponding item type ( e.g. Actions, Test Modules) are correct in 'Select Folder' form")
    public void TC049_folderPathCorrect() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(), "");
        DashBoardPage dashBoardPage = new DashBoardPage();
        PagePopup pagePopup = new PagePopup();
        Log.info("Go to Global Setting -> Add page");
        Log.info("Open Add page popup");
        dashBoardPage.openAddPagePopup();
        Log.info("Enter info into all required fields on New Page dialog");
        pagePopup.addPage("Page 1", "Select parent");
        Thread.sleep(1000);
        Log.info("Create new panel");
        dashBoardPage.createPanel("Panel 4", "  Name");
        String repoName = " Music Library";
        String path = repoName.replace("/", "").trim() + "/Actions";
        Log.info("Change folder path");
        dashBoardPage.changeFolderPath(repoName);
        String folderPath = dashBoardPage.getFolderPath().replaceFirst("/", "");
        Assert.assertEquals(folderPath, path);
    }
}
