package org.candyMapper.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.candyMapper.BaseTest;
import org.openqa.selenium.By;

public class MainScreenPage extends BaseTest {

    final By nameField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_NAME']");
    final By emailField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_EMAIL']");
    final By textAreaField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/textarea[@data-aid='CONTACT_FORM_MESSAGE']");

    public void fillNameField() {
        scrollToElement(nameField);
        javaScriptButtonClickAndSendText(nameField, "Tester");
    }

    public void fillEmailField() {
        scrollToElement(emailField);
        javaScriptButtonClickAndSendText(emailField, "email@test.pl");
    }

    public void fillTextAreaField() {
        scrollToElement(textAreaField);
        javaScriptButtonClickAndSendText(textAreaField, RandomStringUtils.randomAlphabetic(100));
    }
}
