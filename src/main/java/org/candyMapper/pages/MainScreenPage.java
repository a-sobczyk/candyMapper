package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;

public class MainScreenPage extends BaseTest {
    protected final By nameField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_NAME']");
    protected final By emailField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_EMAIL']");
    protected final By textAreaField = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/textarea[@data-aid='CONTACT_FORM_MESSAGE']");
    protected final By sendMessageBtn = By.xpath("//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/button");
    protected final By confirmationMessage = By.xpath("//span[contains(text(),'Thank you for your inquiry!')]");
    protected final By invalidEmailAddressMessage = By.xpath("//p[@data-aid='CONTACT_EMAIL_ERR_REND']");
    protected final By ConnectWithSocialMediaTxt = By.xpath("//span[text()='Connect with us on Social Media']");
    protected final By countyIFrame = By.xpath("//div[@id='bs-6']/span/iframe");
    protected final By countyDropdownList = By.xpath("//option");
    protected final By halloweenPodcastLink = By.xpath("//a[@href='https://testguild.com/podcast/automation/a472-paul/']");
    protected final By dollarAmountText = By.xpath("//span[contains(text(),'Validate Random Dollar Amounts')]");
}
