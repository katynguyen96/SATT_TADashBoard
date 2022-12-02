package com.tadashboard.common.utilities;

import com.tadashboard.common.utilities.reader.ConfigFileReader;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    static WebDriver driver;
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    public static WebDriver getDriver() {
        return driver;
    }

    public static void open(String url) {
        setupDriver(configFileReader.getBrowserDriver());
        driver.get(url);
    }

    private static void setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                initChromeDriver();
                break;
            case "firefox":
                initFirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                initChromeDriver();
        }
    }

    private static void setupBrowser() {
        maximizeWindow();
        pageLoadTimeout();
        implicitlyWait();
    }

    private static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    private static void pageLoadTimeout() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(configFileReader.getPageLoadTimeout()));
    }

    private static void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(configFileReader.getImplicitlyWait()));
    }

    private static void initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        driver = new ChromeDriver();
        setupBrowser();
    }

    private static void initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\Executables\\geckodriver.exe");
        driver = new FirefoxDriver();
        setupBrowser();
    }

    private static WebDriverWait explicitlyWait(long duration) {
        return new WebDriverWait(driver, Duration.ofSeconds(duration));
    }

    public static WebElement waitToBeClickable(WebElement element, long duration) {
        return explicitlyWait(duration).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitInVisibility(WebElement element, long duration) {
        explicitlyWait(duration).until(ExpectedConditions.invisibilityOf(element));
    }

    public static void scrollToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    public static void setImplicitlyWait(long duration) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
    }

    public static void hover(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public static String getAlertMessage() {
        return driver.switchTo().alert().getText();
    }

    public static String getTitle(){
        return DriverManager.getTitle();
    }

    public static Boolean isAlertDisplayed() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    public static void close() {
        driver.quit();
    }
}
