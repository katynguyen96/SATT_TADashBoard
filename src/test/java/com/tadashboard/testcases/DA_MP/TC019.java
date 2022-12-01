package com.tadashboard.testcases.DA_MP;

import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.BasePage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC019 extends BaseTestSetUp {
    @Test(description = "Verify that user is able to add additional sibling page levels to the parent page successfully")
    public void TC019_AddAdditionalSiblingPage(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(),"");
        BasePage basePage = new BasePage();
        Log.info("Go to Global Setting -> Add page");
        Log.info("Enter info into all required fields on New Page dialog");
        basePage.addPage("Page 1","Overview");
        Assert.assertTrue(basePage.isPageChildrenDisplay("Page 1"));
    }
}
