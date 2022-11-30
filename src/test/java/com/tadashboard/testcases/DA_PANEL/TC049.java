package com.tadashboard.testcases.DA_PANEL;

import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.pageObjects.TADashBoard.BasePage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC049 extends BaseTestSetUp {
    @Test(description = "Verify that user is able to add additional sibling page levels to the parent page successfully")
    public void TC049_folderPathCorrect() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login("test","test");
        BasePage basePage = new BasePage();
        Log.info("Go to Global Setting -> Add page");
        Log.info("Enter info into all required fields on New Page dialog");
        basePage.addPage("Page 1","Select parent");
        Thread.sleep(1000);
        basePage.createPanel("Panel 8","name");
        String repoName = " Music Library";
        String path = "/"+repoName+"/Actions";
        basePage.changeFolderPath(repoName);
        String folderPath = basePage.getFolderPath();
        Assert.assertEquals(folderPath,path);
    }
}
