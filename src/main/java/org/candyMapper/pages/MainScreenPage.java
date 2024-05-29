package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;

public class MainScreenPage extends BaseTest {
    protected final By nameField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_NAME']");
    protected final By emailField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_EMAIL']");
    protected final By textAreaField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/textarea[@data-aid='CONTACT_FORM_MESSAGE']");
    protected final By sendMessageBtn = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/button");
    protected final By confirmationMessage = By.xpath("//span[contains(text(),'Thank you for your inquiry!')]");
}
