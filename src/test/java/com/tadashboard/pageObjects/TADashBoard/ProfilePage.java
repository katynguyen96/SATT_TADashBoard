package com.tadashboard.pageObjects.TADashBoard;

import com.tadashboard.common.utilities.DriverManager;
import com.tadashboard.common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProfilePage extends BasePage {
    private final By txtProfileName = By.xpath("//input[@id='txtProfileName']");
    private final By btnNext = By.xpath("//input[@value='Next']");
    private final By liFilterField = By.xpath("//li[text()='Filter Fields']");
    private final By btnAddFilter = By.xpath("//button[text()=' Add']");
    private final By btnRemoveFilter = By.xpath("//button[text()=' Remove']");

    private final String filterXpath = "//option[text()='%s']";
    private final By cbbField = By.id("cbbField");
    private final By cbbOperator = By.id("cbbCondition");
    private final By txtValue = By.id("txtSearchText");
    private final String randomValue = Utilities.randomString(5);

    private WebElement getTxtProfileName() {
        return DriverManager.getDriver().findElement(txtProfileName);
    }

    private WebElement getBtnNext() {
        return DriverManager.getDriver().findElement(btnNext);
    }

    private WebElement getLiFilterField() {
        return DriverManager.getDriver().findElement(liFilterField);
    }

    private WebElement getCbbField() {
        return DriverManager.getDriver().findElement(cbbField);
    }

    private Select getField() {
        return new Select(getCbbField());
    }

    private WebElement getCbbOperator() {
        return DriverManager.getDriver().findElement(cbbOperator);
    }

    private Select getOperator() {
        return new Select(getCbbOperator());
    }

    private WebElement getTxtValue() {
        return DriverManager.getDriver().findElement(txtValue);
    }

    private WebElement getBtnAddFilter() {
        return DriverManager.getDriver().findElement(btnAddFilter);
    }

    private WebElement getBtnRemoveFilter() {
        return DriverManager.getDriver().findElement(btnRemoveFilter);
    }


    public List<String> getItemTypesValue() {
        return getItemTypes().getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickAddNewProfileButton(){
        getLnkAddNew().click();
    }

    public void navigateToProfilePage(){
        DriverManager.hover(DriverManager.getDriver(), getLnkAdmin());
        getLnkProfiles().click();
    }

    public void addNewProfile(String name) {
        clickAddNewProfileButton();
        getTxtProfileName().sendKeys(name);
        getBtnNext().click();
    }

    public void navigateToFilterField() throws InterruptedException {
        Thread.sleep(1000);
        getLiFilterField().click();
    }

    public void addNewFilter() {
        getTxtValue().sendKeys(randomValue);
        getBtnAddFilter().click();
    }

    public String getFieldValueSelect() {
        return getField().getFirstSelectedOption().getText();
    }

    public String getOperatorValueSelect() {
        return getOperator().getFirstSelectedOption().getText();
    }

    public void removeFilter() {
        String filter = getFieldValueSelect() + getOperatorValueSelect() + '"' + randomValue + '"';
        DriverManager.getDriver().findElement(By.xpath(String.format(filterXpath, filter))).click();
        getBtnRemoveFilter().click();
    }

    public boolean isFilterDisplayed() {
        try {
            String filter = getFieldValueSelect() + getOperatorValueSelect() + '"' + randomValue + '"';
            return DriverManager.getDriver().findElement(By.xpath(String.format(filterXpath, filter))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
