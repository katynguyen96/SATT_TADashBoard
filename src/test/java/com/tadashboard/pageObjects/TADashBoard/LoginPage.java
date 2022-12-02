package com.tadashboard.pageObjects.TADashBoard;

import com.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    private final By txtUsername = By.id("username");
    private final By txtPassword = By.id("password");
    private final By btnLogin = By.className("btn-login");
    private final By ddlListRepo = By.xpath("//select[@class='list']");


    private WebElement getTxtUsername(){
        return DriverManager.getDriver().findElement(txtUsername);
    }

    private WebElement getTxtPassword(){
        return DriverManager.getDriver().findElement(txtPassword);
    }

    private WebElement getBtnLogin(){
        return DriverManager.getDriver().findElement(btnLogin);
    }
    private WebElement getDdlListRepo(){
        return DriverManager.getDriver().findElement(ddlListRepo);
    }

    private Select listRepo(){
        return new Select(getDdlListRepo());
    }

    public void login(String username, String password){
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getBtnLogin().click();
    }

    public void selectRepo(String repoName){
        listRepo().selectByVisibleText(repoName);
    }
}
