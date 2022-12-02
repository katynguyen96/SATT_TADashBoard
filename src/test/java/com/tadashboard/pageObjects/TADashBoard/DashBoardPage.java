package com.tadashboard.pageObjects.TADashBoard;

import com.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashBoardPage {
private final By lnkAddPage = By.xpath("//li[@class='mn-setting']//a[@class='add']");
    private final String lnkPageChildren = "//a[text()='Overview']/..//a[text()='%s']";
    private final By btnOk = By.id("OK");
    private final String lnkProject = "//a[text() ='%s']";
    private final By lnkLogout = By.xpath("//a[@href='logout.do']");
    private final By lnkWelcome = By.xpath("//a[@href='#Welcome']");
    private final By btnGlobalSetting = By.xpath("//li[@class='mn-setting']");
    private final By btnAddPage = By.xpath("//a[text()='Add Page']");
    private final By txtPageName = By.id("name");
    private final By ckbPublic = By.id("ispublic");
    private final By btnOK = By.id("OK");
    private final By ddlDisplayAfter = By.id("afterpage");
    private final By btnRaiway = By.xpath("//a[@class='active haschild']");
    private final By ddlParentPage = By.id("parent");

    private WebElement getLnkAddPage() {
        return DriverManager.getDriver().findElement(lnkAddPage);
    }
    
    private WebElement btnBreadcrum(String option) {
        By breadcrum = By.xpath("//a[contains(text(),'" + option + "')]");
        return DriverManager.getDriver().findElement(breadcrum);
    }


    private WebElement getLnkLogout() {
        return DriverManager.getDriver().findElement(lnkLogout);
    }

    private WebElement getDdlDisplayAfter() {
        return DriverManager.getDriver().findElement(ddlDisplayAfter);
    }

    private WebElement getbtnGlobalSetting() {
        return DriverManager.getDriver().findElement(btnGlobalSetting);
    }

    private WebElement getBtnAddPage() {
        return DriverManager.getDriver().findElement(btnAddPage);
    }

    private WebElement getLnkWelcome() {
        return DriverManager.getDriver().findElement(lnkWelcome);
    }

    private WebElement getTxtPageName() {
        return DriverManager.getDriver().findElement(txtPageName);
    }

    private WebElement getCkbPublic() {
        return DriverManager.getDriver().findElement(ckbPublic);
    }

    private WebElement getBtnOK() {
        return DriverManager.getDriver().findElement(btnOK);
    }

    private WebElement getDdlParentPage() {
        return DriverManager.getDriver().findElement(ddlParentPage);
    }


    private WebElement getBtnRaiway() {
        return DriverManager.getDriver().findElement(btnRaiway);
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

    
    public void logout() {
        DriverManager.Hover(DriverManager.getDriver(), getLnkWelcome());
        getLnkLogout().click();
    }

    public void navigateAddPage() {
        DriverManager.Hover(DriverManager.getDriver(), getbtnGlobalSetting());
        getBtnAddPage().click();
    }

    public void navigateBreadcrum(String option) {
        DriverManager.Hover(DriverManager.getDriver(), getBtnRaiway());
        DriverManager.Hover(DriverManager.getDriver(), btnBreadcrum(option));
    }

    public void fillInfoNewPage(String pageName, String value, String parentPage) {
        getTxtPageName().sendKeys(pageName);
        getCkbPublic().click();
        chooseDdlOptionByValue(getDdlDisplayAfter(), value);
        chooseDdlOptionByValue(getDdlParentPage(), parentPage);
        getBtnOK().click();
    }

    public void chooseDdlOptionByValue(WebElement element, String value) {
        Select selectOption = new Select(element);
        selectOption.selectByVisibleText(value);
    }

}
