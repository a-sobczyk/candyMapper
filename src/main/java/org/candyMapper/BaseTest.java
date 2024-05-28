package org.candyMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Level;

public class BaseTest {

    public static Properties PROPERTIES;
    public static WebDriver driver;

    @BeforeAll
    public static void testDataSetup() {
        try {
            File config = new File("configuration.properties");
            FileInputStream configStream = new FileInputStream(config);
            PROPERTIES = new Properties();
            PROPERTIES.load(configStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        WebDriverManager.chromedriver().setup();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.INFO);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        options.addArguments("--incognito");
        options.addArguments("--verbose");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        String url = PROPERTIES.getProperty("CANDY_MAPPER_URL");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void buttonClick(By by) {
        waitElementToBePresent(by);
        driver.findElement(by).click();
    }

    public void javaScriptButtonClickAndSendText(By by, String text) {
        waitElementToBePresent(by);
        WebElement field = driver.findElement(by);
        new Actions(driver).click(field).sendKeys(field, text).perform();
    }

    public void javaScriptButtonClick(By by) {
        waitElementToBePresent(by);
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void waitElementToBePresent(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("ELEMENT NIE WIDOCZNY: ---> " + this.getClass().getSimpleName() + ", ---> " + by.toString());
        }
    }

    public boolean waitElementToBePresent(By by, Integer sec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("ELEMENT NIE WIDOCZNY: ---> " + this.getClass().getSimpleName() + ", ---> " + by.toString());
            return false;
        }
        return true;
    }

    public void waitUntilElementIsStaleness(By by, Integer sec) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.stalenessOf((WebElement) by));
        } catch (Exception e) {
            System.out.println("ELEMENT JEST DALEJ WIDOCZNY: ---> " + this.getClass().getSimpleName() + ", ---> " + by.toString());
        }
    }

    public boolean waitElementToBeClickable(By by) {
        boolean clickable = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(by));
            clickable = true;
        } catch (Exception e) {
            System.out.println("ELEMENT NIE WIDOCZNY: ---> " + this.getClass().getSimpleName() + ", ---> " + by.toString());
        }
        return clickable;
    }

    public void scrollToElement(By by) {
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}
