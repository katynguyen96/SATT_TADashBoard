package com.tadashboard.pageObjects.TADashBoard;

import com.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends BasePage{
    private final By lnkAddPage = By.xpath("//li[@class='mn-setting']//a[@class='add']");
    private final String lnkPageChildren = "//a[text()='Overview']/..//a[text()='%s']";
    private final By btnOk = By.id("OK");
    private final String lnkProject = "//a[text() ='%s']";

    private WebElement getLnkAddPage() {
        return DriverManager.getDriver().findElement(lnkAddPage);
    }
    public void openAddPagePopup(){
        DriverManager.hover(DriverManager.getDriver(), getLnkSetting());
        getLnkAddPage().click();
    }
    protected WebElement getBtnOK() {
        return DriverManager.getDriver().findElement(btnOk);
    }

    public Boolean isPageChildrenDisplay(String pageName) {
        DriverManager.hover(DriverManager.getDriver(), getLnkOverView());
        return getLnkOverView().findElement(By.xpath(String.format(lnkPageChildren, pageName))).isDisplayed();
    }

    public void createPanel(String panelName, String series) {
        DriverManager.hover(DriverManager.getDriver(), getLnkSetting());
        getLnkCreatePanel().click();
        fillInfoAddPanel(panelName,series);
        getPanelConfigOk().click();
    }

    public void fillInfoAddPanel(String panelName, String series){
        getTxtDisplayName().sendKeys(panelName);
        getSeries().selectByVisibleText(series);
        getBtnOK().click();
    }

    public void changeFolderPath(String projectName) {
        getBtnEditPanel().click();
        getLnkOpenFolder().click();
        DriverManager.getDriver().findElement(By.xpath(String.format(lnkProject, projectName))).click();
        getLnkToggle(projectName).click();
        getLnkActions().click();
        getBtnSelectFolderOK().click();
    }

    public void addNewPanel(String panelName, String series) {
        DriverManager.hover(DriverManager.getDriver(), getLnkAdmin());
        getLnkPanels().click();
        getLnkAddNew().click();
        fillInfoAddPanel(panelName,series);
    }

}
