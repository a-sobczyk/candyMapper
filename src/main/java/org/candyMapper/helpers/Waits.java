package org.candyMapper.helpers;

import org.candyMapper.BaseTest;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits extends BaseTest {

    /**
     * Czeka na element zlokalizowany za pomoca parametru "element"
     *
     * @param element lokator elemenytu
     */
    public void waitElementToBePresent(WebElement element) {
        log.info("Czekam na element: " + element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Czeka na element zlokalizowany za pomoca parametru
     *
     * @param element lokator elemenytu
     * @param sec     ilosc sekund oczekiwania na element
     * @return zwraca wartosc true jesli element jest widoczny lub false jesli nie
     */
    public boolean waitElementToBePresent(WebElement element, Integer sec) {
        log.info("Czekam na element: " + element);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            log.error("ERROR", e);
            return false;
        }
        return true;
    }

    /**
     * Oczekuje na znikniecie elementu zlokalizowanego za pomoca parametru
     *
     * @param element lokator elemenytu
     * @param sec     ilosc sekund oczekiwania na znikniecie elementu
     */
    public void waitUntilElementIsStaleness(WebElement element, Integer sec) {
        log.info("Czekam na element: " + element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Oczekuje az w element bedzie mozna kliknac
     *
     * @param element lokator elemenytu
     */
    public void waitElementToBeClickable(WebElement element) {
        log.info("Czekam na element: " + element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Przerywa dzialanie skryptu na przeslana ilosc milisekund
     *
     * @param milliseconds ilosc milisekund oczekiwania
     */
    public void millisecondsWait(int milliseconds) {
        log.info("Czekam na element przez: " + milliseconds + "ms");
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.error("ERROR", e);
            Thread.currentThread().interrupt();
        }
    }
}
