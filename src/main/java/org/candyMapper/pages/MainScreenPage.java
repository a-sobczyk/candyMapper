package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainScreenPage extends BaseTest {
    @FindBy(xpath = "//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_NAME']")
    public WebElement nameField;
    @FindBy(xpath = "//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/input[@data-aid='CONTACT_FORM_EMAIL']")
    public WebElement emailField;
    @FindBy(xpath = "//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/textarea[@data-aid='CONTACT_FORM_MESSAGE']")
    public WebElement textAreaField;
    @FindBy(xpath = "//div[@data-aid='CONTACT_FORM_CONTAINER_REND']/form/div/div/div/button")
    public WebElement sendMessageBtn;
    @FindBy(xpath = "//span[contains(text(),'Thank you for your inquiry!')]")
    public WebElement confirmationMessage;
    @FindBy(xpath = "//p[@data-aid='CONTACT_EMAIL_ERR_REND']")
    public WebElement invalidEmailAddressMessage;
    @FindBy(xpath = "//span[text()='Connect with us on Social Media']")
    public WebElement ConnectWithSocialMediaTxt;
    @FindBy(xpath = "//div[@id='bs-6']/span/iframe")
    public WebElement countyIFrame;
    @FindBy(xpath = "//option")
    public List<WebElement> countyDropdownList;
    @FindBy(xpath = "//a[@href='https://testguild.com/podcast/automation/a472-paul/']")
    public WebElement halloweenPodcastLink;
    @FindBy(xpath = "//span[contains(text(),'Validate Random Dollar Amounts')]")
    public WebElement dollarAmountText;
}