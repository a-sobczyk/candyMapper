package org.candyMapper.helpers;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits extends BaseTest {

    public void waitElementToBePresent(By by) {
        log.info("Czekam na element: " + by);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            System.out.println("ELEMENT NIE WIDOCZNY: ---> " + this.getClass().getSimpleName() + ", ---> " + by.toString());
        }
    }

    public boolean waitElementToBePresent(By by, Integer sec) {
        log.info("Czekam na element: " + by);
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
        log.info("Czekam na element: " + by);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            wait.until(ExpectedConditions.stalenessOf((WebElement) by));
        } catch (Exception e) {
            System.out.println("ELEMENT JEST DALEJ WIDOCZNY: ---> " + this.getClass().getSimpleName() + ", ---> " + by.toString());
        }
    }

    public void waitElementToBeClickable(By by) {
        log.info("Czekam na element: " + by);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            System.out.println("ELEMENT NIE WIDOCZNY: ---> " + this.getClass().getSimpleName() + ", ---> " + by.toString());
        }
    }

    public void millisecondsWait(int milliseconds) {
        log.info("Czekam na element przez: " + milliseconds + "ms");
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
