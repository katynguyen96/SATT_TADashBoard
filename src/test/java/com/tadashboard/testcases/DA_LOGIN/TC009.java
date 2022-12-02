package com.tadashboard.testcases.DA_LOGIN;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC009 extends BaseTestSetUp {
    @Test(description = "Verify that username with special characters is working correctly")
    public void TC009_LoginSpecialCharacter() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login("minh!@^","");
        Thread.sleep(1000);
        String DBTitle = DriverManager.getDriver().getTitle();
        Assert.assertEquals(DBTitle,"TestArchitect ™ - Execution Dashboard");
    }
}
