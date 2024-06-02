package org.candyMapper.helpers;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class PageOperators extends BaseTest {

    private final Waits waits = new Waits();

    public void buttonClick(By by) {
        log.info("Przed kliknieciem przycisku: " + by);
        waits.waitElementToBePresent(by);
        driver.findElement(by).click();
        log.info("Po kliknieciu przycisku: " + by);
    }

    public void javaScriptButtonClickAndSendText(By by, String text) {
        log.info("Przed kliknieciem przycisku i wpisaniu tekstu: " + by);
        waits.waitElementToBePresent(by);
        WebElement field = driver.findElement(by);
        new Actions(driver).click(field).sendKeys(field, text).perform();
        log.info("Po kliknieciu i wpisaniu tekstu: " + by);
    }

    public void javaScriptButtonClick(By by) {
        log.info("Przed kliknieciem przycisku: " + by);
        waits.waitElementToBeClickable(by);
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Po kliknieciu i wpisaniu tekstu: " + by);
    }

    public void scrollToElement(By by) {
        log.info("Scrolluje do elementu: " + by);
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public String getText(By by) {
        log.info("Pobieram tekst elementu: " + by);
        waits.waitElementToBePresent(by);
        WebElement element = driver.findElement(by);
        log.info("Pobralem tekst elementu: " + by);
        return element.getText();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public void changeTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
