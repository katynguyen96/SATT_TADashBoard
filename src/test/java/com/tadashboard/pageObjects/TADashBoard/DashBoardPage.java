package com.tadashboard.pageObjects.TADashBoard;

import com.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashBoardPage {
    private final By lnkLogout = By.xpath("//a[@href='logout.do']");
    private final By lnkWelcome = By.xpath("//a[@href='#Welcome']");

    public void logout(){
        DriverManager.Hover(DriverManager.getDriver(),getLnkWelcome());
        getLnkLogout().click();
    }

    private WebElement getLnkLogout(){
        return DriverManager.getDriver().findElement(lnkLogout);
    }

    private WebElement getLnkWelcome(){
        return DriverManager.getDriver().findElement(lnkWelcome);
    }
}
