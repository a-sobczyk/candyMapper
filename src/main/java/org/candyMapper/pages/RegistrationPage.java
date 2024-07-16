package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BaseTest {
    @FindBy(xpath = "//a[text()='Create account.']")
    public WebElement createAccountLink;
    @FindBy(xpath = "//input[@name='nameFirst']")
    public WebElement firstNameField;
    @FindBy(xpath = "//input[@name='nameLast']")
    public WebElement lastNameField;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;
    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneField;
    @FindBy(xpath = "//button[@data-ux='ButtonPrimary']")
    public WebElement createAccountBtn;
    @FindBy(xpath = "//h4[@data-ux='Heading']")
    public WebElement confirmationHeading;
    @FindBy(xpath = "//p[@data-aid='CREATE_ACCOUNT_DESCRIPTION_REND']")
    public WebElement confirmationMessage;
}
