package com.tadashboard.testcases.DA_PANEL;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.common.utilities.logs.Log;
import com.tadashboard.common.utilities.reader.ConfigFileReader;
import com.tadashboard.pageObjects.TADashBoard.DashBoardPage;
import com.tadashboard.pageObjects.TADashBoard.LoginPage;
import com.tadashboard.testcases.BaseTestSetUp;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC029 extends BaseTestSetUp {
    @Test(description = "Verify that user is unable to create new panel when (*) required field is not filled")
    public void TC029_AddEmptyPanel() {
        ConfigFileReader configFileReader = new ConfigFileReader();
        LoginPage loginPage = new LoginPage();
        Log.info("Login with valid account");
        loginPage.login(configFileReader.getUsername(), "");
        DashBoardPage dashBoardPage = new DashBoardPage();
        Log.info("Click on Administer/Panels link");
        Log.info("Click on Add new link");
        Log.info("Click on OK button");
        dashBoardPage.addNewPanel("", "Select a field...");
        String message = DriverManager.getAlertMessage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(DriverManager.isAlertDisplayed());
        softAssert.assertEquals(message, "Display Name is a required field.");
        softAssert.assertAll();
    }
}
