package com.tadashboard.testcases.DA_LOGIN;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC002 extends BaseTestSetUp {
    @Test(description = "Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials")
    public void TC002() {
        LoginPage loginPage = new LoginPage();
        Log.info("Login with invalid account");
        loginPage.login("abc", "abc");
        DriverManager.setImplicitlyWait(5);

        Log.info("Verify that Dashboard Error message Username or password is invalid appears");
        String mess = DriverManager.getAlertMessage();
        Assert.assertEquals(mess, "Username or password is invalid");
    }
}
