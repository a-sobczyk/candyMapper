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

    /**
     * Metoda klikajaca w przycisk przekazany za pomoca parametru "by".
     * @param by lokator przycisku
     */
    public void buttonClick(By by) {
        log.info("Przed kliknieciem przycisku: " + by);
        waits.waitElementToBePresent(by);
        driver.findElement(by).click();
        log.info("Po kliknieciu przycisku: " + by);
    }

    /**
     * Metoda wykonujaca javascript, ktory lokalizuje pole tekstowe za pomoca parametru "by",
     * a nastepnie wkleja text przesłany do metody za pomoca String "text".
     * @param by lokator pola tekstowego.
     * @param text text jaki ma byc wklejony do pola.
     */
    public void javaScriptButtonClickAndSendText(By by, String text) {
        log.info("Przed kliknieciem przycisku i wpisaniu tekstu: " + by);
        waits.waitElementToBePresent(by);
        WebElement field = driver.findElement(by);
        new Actions(driver).click(field).sendKeys(field, text).perform();
        log.info("Po kliknieciu i wpisaniu tekstu: " + by);
    }

    /**
     * Metoda wykonujaca javascript, ktory klika w przycisk przeslany za pomoca parametru "by",
     * @param by lokator przycisku.
     */
    public void javaScriptButtonClick(By by) {
        log.info("Przed kliknieciem przycisku: " + by);
        waits.waitElementToBeClickable(by);
        WebElement element = driver.findElement(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Po kliknieciu i wpisaniu tekstu: " + by);
    }

    /**
     * Metoda wykonujaca javascript, ktory przesuwa ekran do elementu przeslanego za pomoca parametru "by",
     * @param by lokator elementu.
     */
    public void scrollToElement(By by) {
        log.info("Scrolluje do elementu: " + by);
        WebElement element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Metoda pobierajaca tekst ze strony dla elementu przeslanego za pomoca parametru "by",
     * @param by lokator elementu
     * @return String - tekst pobrany ze strony
     */
    public String getText(By by) {
        log.info("Pobieram tekst elementu: " + by);
        waits.waitElementToBePresent(by);
        WebElement element = driver.findElement(by);
        log.info("Pobralem tekst elementu: " + by);
        return element.getText();
    }

    /**
     * Pobiera liste elementow i zwraca liste WebElementow
     * @param by lokator dla listy elementow np: tabela
     * @return Liste WebElementow
     */
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * Zmienia zakladke w przegladarce
     * @param tabNumber nr zakladki
     */
    public void changeTab(int tabNumber) {
        log.info("Zmiana zakładki przeglądarki");
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
