package com.tadashboard.testcases;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.dataObjects.TADashBoardUrl;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestSetUp {
    @BeforeMethod
    public void setUpBrowser() {
        DriverManager.open(TADashBoardUrl.LOGIN.getUrl());;
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.close();
    }
}
