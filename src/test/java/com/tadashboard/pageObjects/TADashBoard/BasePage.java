package com.tadashboard.pageObjects.TADashBoard;

import com.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    private final By lnkLogout = By.xpath("//a[@href='logout.do']");
    private final By lnkWelcome = By.xpath("//a[@href='#Welcome']");
    private final By lnkSetting = By.xpath("//li[@class='mn-setting']/a");
    private final By lnkAddPage = By.xpath("//li[@class='mn-setting']//a[@class='add']");
    private final By txtPageName = By.id("name");
    private final By ddlParentPage = By.xpath("//select[@id='parent']");
    private final By btnOkNewPagePopupOK = By.id("OK");
    private final By lnkPanelConfigurationOk = By.xpath("//div[@id='div_panelConfigurationDlg']//input[@id='OK']");
    private final By lnkAdmin = By.xpath("//a[@href='#Administer']");
    private final By lnkOverView = By.xpath("//li[@class='haschild']");
    private final String lnkPageChildren = "//li[@class='haschild']//a[text()='%s']";
    private final By lnkPanels = By.xpath("//ul[@id='ulAdminister']//a[@href='panels.jsp']");
    private final By lnkAddNew = By.xpath("//a[text()='Add New']");
    private final By btnPanelPopupOK = By.xpath("//div[@class='ui-dialog-container']//input[@id='OK']");
    private final By lnkCreatePanel = By.xpath("//a[.='Create Panel']");
    private final By txtDisplayName = By.id("txtDisplayName");
    private final By ddlSeries = By.xpath("//select[@id='cbbSeriesField']");
    private final By btnEditPanel = By.xpath("//li[@class='edit']");
    private final By lnkOpenFolder = By.xpath("//a[@title='Open']");
    private final String lnkProject = "//a[text() ='%s']";
    private final By btnSelectFolderOK = By.id("btnFolderSelectionOK");
    private final By txtFolderPath = By.id("txtFolder");

    private WebElement getLnkLogout() {
        return DriverManager.getDriver().findElement(lnkLogout);
    }

    private WebElement getLnkSetting() {
        return DriverManager.getDriver().findElement(lnkSetting);
    }

    private WebElement getLnkAddPage() {
        return DriverManager.getDriver().findElement(lnkAddPage);
    }

    private WebElement getLnkWelcome() {
        return DriverManager.getDriver().findElement(lnkWelcome);
    }

    private WebElement getTxtPageName(){
        return DriverManager.getDriver().findElement(txtPageName);
    }

    private WebElement getDdlParentPage(){
        return DriverManager.getDriver().findElement(ddlParentPage);
    }

    private WebElement getBtnOK(){
        return DriverManager.getDriver().findElement(btnOkNewPagePopupOK);
    }

    private Select getParentPage(){
        return new Select(getDdlParentPage());
    }

    private WebElement getLnkAdmin(){
        return DriverManager.getDriver().findElement(lnkAdmin);
    }

    private WebElement getLnkPanels(){
        return DriverManager.getDriver().findElement(lnkPanels);
    }

    private WebElement getLnkAddNew(){
        return DriverManager.getDriver().findElement(lnkAddNew);
    }

    private WebElement getBtnPanelPopupOK(){
        return DriverManager.getDriver().findElement(btnPanelPopupOK);
    }

    private WebElement getLnkOverView(){
        return DriverManager.getDriver().findElement(lnkOverView);
    }

    private WebElement getLnkCreatePanel(){
        return DriverManager.getDriver().findElement(lnkCreatePanel);
    }

    private WebElement getTxtDisplayName(){
        return DriverManager.getDriver().findElement(txtDisplayName);
    }

    private WebElement getDdlSeries(){
        return DriverManager.getDriver().findElement(ddlSeries);
    }

    private Select getSeries(){
        return new Select(getDdlSeries());
    }

    private WebElement getBtnEditPanel(){
        return DriverManager.getDriver().findElement(btnEditPanel);
    }

    private WebElement getLnkOpenFolder(){
        return DriverManager.getDriver().findElement(lnkOpenFolder);
    }

    private WebElement getPanelConfigOk(){
        return DriverManager.getDriver().findElement(lnkPanelConfigurationOk);
    }

    private WebElement getBtnSelectFolderOK(){
        return DriverManager.getDriver().findElement(btnSelectFolderOK);
    }

    private WebElement getTxtFolderPath(){
        return DriverManager.getDriver().findElement(txtFolderPath);
    }

    public String getFolderPath(){
        return getTxtFolderPath().getText();
    }
    public void logout() {
        DriverManager.Hover(DriverManager.getDriver(), getLnkWelcome());
        getLnkLogout().click();
    }

    public void addPage(String pageName, String pageParent) {
        DriverManager.Hover(DriverManager.getDriver(), getLnkSetting());
        getLnkAddPage().click();
        getTxtPageName().sendKeys(pageName);
        getParentPage().selectByVisibleText(pageParent);
        getBtnOK().click();
    }

    public void addEmptyPanel(){
        DriverManager.Hover(DriverManager.getDriver(),getLnkAdmin());
        getLnkPanels().click();
        getLnkAddNew().click();
        getBtnPanelPopupOK().click();
    }

    public Boolean isPageChildrenDisplay(String pageName){
        DriverManager.Hover(DriverManager.getDriver(),getLnkOverView());
        return getLnkOverView().findElement(By.xpath(String.format(lnkPageChildren,pageName))).isDisplayed();
    }

    public void createPanel(String panelName, String series) {
        DriverManager.Hover(DriverManager.getDriver(), getLnkSetting());
        getLnkCreatePanel().click();
        getTxtDisplayName().sendKeys(panelName);
        getSeries().selectByValue(series);
        getBtnOK().click();
        getPanelConfigOk().click();
    }

    public void changeFolderPath(String projectName){
        getBtnEditPanel().click();
        getLnkOpenFolder().click();
        DriverManager.getDriver().findElement(By.xpath(String.format(lnkProject, projectName))).click();
        getBtnSelectFolderOK().click();
    }
}
