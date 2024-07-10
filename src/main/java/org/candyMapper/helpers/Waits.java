package org.candyMapper.helpers;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits extends BaseTest {

    /**
     * Czeka na element zlokalizowany za pomoca parametru "by"
     *
     * @param by lokator elemenytu
     */
    public void waitElementToBePresent(By by) {
        log.info("Czekam na element: " + by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Czeka na element zlokalizowany za pomoca parametru
     *
     * @param by  lokator elemenytu
     * @param sec ilosc sekund oczekiwania na element
     * @return zwraca wartosc true jesli element jest widoczny lub false jesli nie
     */
    public boolean waitElementToBePresent(By by, Integer sec) {
        log.info("Czekam na element: " + by);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            log.error("ERROR", e);
            return false;
        }
        return true;
    }

    /**
     * Oczekuje na znikniecie elementu zlokalizowanego za pomoca parametru
     *
     * @param by  lokator elemenytu
     * @param sec ilosc sekund oczekiwania na znikniecie elementu
     */
    public void waitUntilElementIsStaleness(By by, Integer sec) {
        log.info("Czekam na element: " + by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.stalenessOf((WebElement) by));
    }

    /**
     * Oczekuje az w element bedzie mozna kliknac
     *
     * @param by lokator elemenytu
     */
    public void waitElementToBeClickable(By by) {
        log.info("Czekam na element: " + by);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(by));
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
