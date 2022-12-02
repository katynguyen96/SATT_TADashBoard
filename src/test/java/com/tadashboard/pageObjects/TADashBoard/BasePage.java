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
    private final By lnkOverView = By.xpath("//li[@class='active haschild']");
    private final String lnkPageChildren = "//li[@class='active haschild']//a[text()='%s']";
    private final By lnkPanels = By.xpath("//ul[@id='ulAdminister']//a[@href='panels.jsp']");
    private final By lnkDataProfiles = By.xpath("//ul[@id='ulAdminister']//a[@href='profiles.jsp']");
    private final By ddlItemTypes = By.xpath("//select[@id='cbbEntityType']");
    private final By lnkAddNew = By.xpath("//a[text()='Add New']");
    private final By btnPanelPopupOK = By.xpath("//div[@class='ui-dialog-container']//input[@id='OK']");
    private final By lnkCreatePanel = By.xpath("//a[.='Create Panel']");
    private final By txtDisplayName = By.id("txtDisplayName");
    private final By ddlSeries = By.xpath("//select[@id='cbbSeriesField']");
    private final By btnEditPanel = By.xpath("//li[@class='edit']");
    private final By lnkOpenFolder = By.xpath("//a[@title='Open']");
    private final String lnkProject = "//a[text() ='%s']";
    private final String lnkToggle = "//a[text()='%s']//preceding-sibling::a";
    private final By lnkActions = By.xpath("//a[text()=' Actions']");
    private final By btnSelectFolderOK = By.id("btnFolderSelectionOK");
    private final By txtFolderPath = By.id("txtFolder");

    protected WebElement getLnkLogout() {
        return DriverManager.getDriver().findElement(lnkLogout);
    }

    protected WebElement getLnkSetting() {
        return DriverManager.getDriver().findElement(lnkSetting);
    }

    protected WebElement getLnkAddPage() {
        return DriverManager.getDriver().findElement(lnkAddPage);
    }

    protected WebElement getLnkWelcome() {
        return DriverManager.getDriver().findElement(lnkWelcome);
    }

    protected WebElement getTxtPageName() {
        return DriverManager.getDriver().findElement(txtPageName);
    }

    protected WebElement getDdlParentPage() {
        return DriverManager.getDriver().findElement(ddlParentPage);
    }

    protected WebElement getBtnOK() {
        return DriverManager.getDriver().findElement(btnOkNewPagePopupOK);
    }

    protected Select getParentPage() {
        return new Select(getDdlParentPage());
    }

    protected WebElement getLnkAdmin() {
        return DriverManager.getDriver().findElement(lnkAdmin);
    }

    protected WebElement getLnkPanels() {
        return DriverManager.getDriver().findElement(lnkPanels);
    }

    protected WebElement getLnkProfiles() {
        return DriverManager.getDriver().findElement(lnkDataProfiles);
    }

    protected WebElement getDdlItemTypes() {
        return DriverManager.getDriver().findElement(ddlItemTypes);
    }

    protected Select getItemTypes() {
        return new Select(getDdlItemTypes());
    }

    protected WebElement getLnkAddNew() {
        return DriverManager.getDriver().findElement(lnkAddNew);
    }

    protected WebElement getBtnPanelPopupOK() {
        return DriverManager.getDriver().findElement(btnPanelPopupOK);
    }

    protected WebElement getLnkOverView() {
        return DriverManager.getDriver().findElement(lnkOverView);
    }

    protected WebElement getLnkCreatePanel() {
        return DriverManager.getDriver().findElement(lnkCreatePanel);
    }

    protected WebElement getTxtDisplayName() {
        return DriverManager.getDriver().findElement(txtDisplayName);
    }

    protected WebElement getDdlSeries() {
        return DriverManager.getDriver().findElement(ddlSeries);
    }

    protected Select getSeries() {
        return new Select(getDdlSeries());
    }

    protected WebElement getBtnEditPanel() {
        return DriverManager.getDriver().findElement(btnEditPanel);
    }

    protected WebElement getLnkOpenFolder() {
        return DriverManager.getDriver().findElement(lnkOpenFolder);
    }

    protected WebElement getPanelConfigOk() {
        return DriverManager.getDriver().findElement(lnkPanelConfigurationOk);
    }

    protected WebElement getBtnSelectFolderOK() {
        return DriverManager.getDriver().findElement(btnSelectFolderOK);
    }

    protected WebElement getTxtFolderPath() {
        return DriverManager.getDriver().findElement(txtFolderPath);
    }

    protected WebElement getLnkToggle(String projectName) {
        return DriverManager.getDriver().findElement(By.xpath(String.format(lnkToggle, projectName)));
    }

    protected WebElement getLnkActions() {
        return DriverManager.getDriver().findElement(lnkActions);
    }

    public String getFolderPath() {
        return getTxtFolderPath().getAttribute("value");
    }

    public void logout() {
        DriverManager.hover(DriverManager.getDriver(), getLnkWelcome());
        getLnkLogout().click();
    }

    public void addPage(String pageName, String pageParent) {
        DriverManager.hover(DriverManager.getDriver(), getLnkSetting());
        getLnkAddPage().click();
        getTxtPageName().sendKeys(pageName);
        getParentPage().selectByVisibleText(pageParent);
        getBtnOK().click();
    }

    public void addEmptyPanel() {
        DriverManager.hover(DriverManager.getDriver(), getLnkAdmin());
        getLnkPanels().click();
        getLnkAddNew().click();
        getBtnPanelPopupOK().click();
    }

    public Boolean isPageChildrenDisplay(String pageName) {
        DriverManager.hover(DriverManager.getDriver(), getLnkOverView());
        return getLnkOverView().findElement(By.xpath(String.format(lnkPageChildren, pageName))).isDisplayed();
    }

    public void createPanel(String panelName, String series) {
        DriverManager.hover(DriverManager.getDriver(), getLnkSetting());
        getLnkCreatePanel().click();
        getTxtDisplayName().sendKeys(panelName);
        getSeries().selectByValue(series);
        getBtnOK().click();
        getPanelConfigOk().click();
    }

    public void changeFolderPath(String projectName) {
        getBtnEditPanel().click();
        getLnkOpenFolder().click();
        DriverManager.getDriver().findElement(By.xpath(String.format(lnkProject, projectName))).click();
        getLnkToggle(projectName).click();
        getLnkActions().click();
        getBtnSelectFolderOK().click();
    }
}
