package com.tadashboard.pageObjects.TADashBoard;

import com.tadashboard.common.utilities.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PagePopup {
    private final By txtPageName = By.id("name");
    private final By ddlParentPage = By.xpath("//select[@id='parent']");
    private final By popupPage = By.id("div_popup");
    private final By btnOkNewPagePopupOK = By.id("OK");
    protected WebElement getTxtPageName() {
        return DriverManager.getDriver().findElement(txtPageName);
    }
    protected WebElement getDdlParentPage() {
        return DriverManager.getDriver().findElement(ddlParentPage);
    }
    protected WebElement getBtnOK() {
        return DriverManager.getDriver().findElement(btnOkNewPagePopupOK);
    }
    private WebElement getPopupPage(){
        return DriverManager.getDriver().findElement(popupPage);
    }
    protected Select getParentPage() {
        return new Select(getDdlParentPage());
    }
    public void addPage(String pageName, String pageParent) {
        getTxtPageName().sendKeys(pageName);
        getParentPage().selectByVisibleText(pageParent);
        getBtnOK().click();
    }

    public void waitPopupDisapear(){
        DriverManager.waitInVisibility(getPopupPage(),5);
    }
}
