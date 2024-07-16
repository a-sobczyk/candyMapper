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
     * Metoda klikajaca w przycisk przekazany za pomoca parametru "element".
     * @param element lokator przycisku
     */
    public void buttonClick(WebElement element) {
        log.info("Przed kliknieciem przycisku: " + element);
        waits.waitElementToBePresent(element);
        element.click();
        log.info("Po kliknieciu przycisku: " + element);
    }

    /**
     * Metoda wykonujaca javascript, ktory lokalizuje pole tekstowe za pomoca parametru "element",
     * a nastepnie wkleja text przesłany do metody za pomoca String "text".
     * @param element lokator pola tekstowego.
     * @param text text jaki ma byc wklejony do pola.
     */
    public void javaScriptButtonClickAndSendText(WebElement element, String text) {
        log.info("Przed kliknieciem przycisku i wpisaniu tekstu: " + element);
        waits.waitElementToBePresent(element);
        new Actions(driver).click(element).sendKeys(element, text).perform();
        log.info("Po kliknieciu i wpisaniu tekstu: " + element);
    }

    /**
     * Metoda wykonujaca javascript, ktory klika w przycisk przeslany za pomoca parametru "element",
     * @param element lokator przycisku.
     */
    public void javaScriptButtonClick(WebElement element) {
        log.info("Przed kliknieciem przycisku: " + element);
        waits.waitElementToBeClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Po kliknieciu i wpisaniu tekstu: " + element);
    }

    /**
     * Metoda wykonujaca javascript, ktory przesuwa ekran do elementu przeslanego za pomoca parametru "element",
     * @param element lokator elementu.
     */
    public void scrollToElement(WebElement element) {
        log.info("Scrolluje do elementu: " + element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    /**
     * Metoda pobierajaca tekst ze strony dla elementu przeslanego za pomoca parametru "element",
     * @param element lokator elementu
     * @return String - tekst pobrany ze strony
     */
    public String getText(WebElement element) {
        log.info("Pobieram tekst elementu: " + element);
        waits.waitElementToBePresent(element);
        log.info("Pobralem tekst elementu: " + element);
        return element.getText();
    }

    /**
     * Pobiera liste elementow i zwraca liste WebElementow
     * @param element lokator dla listy elementow np: tabela
     * @return Liste WebElementow
     */
    public List<WebElement> findElements(WebElement element) {
        return driver.findElements((By) element);
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
