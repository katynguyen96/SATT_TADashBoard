package com.tadashboard.testcases.DA_LOGIN;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC009 extends BaseTestSetUp {
    @Test
    public void TC004_LoginDifferentRepo() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login("minh!@^","");
        String DBUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(DBUrl.contains("http://localhost/TADashboard/"));
    }
}
