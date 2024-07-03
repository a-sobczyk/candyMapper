package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;

public class RegistrationPage extends BaseTest {

    protected final By createAccountLink = By.xpath("//a[text()='Create account.']");
    protected final By firstNameField = By.xpath("//input[@name='nameFirst']");
    protected final By lastNameField = By.xpath("//input[@name='nameLast']");
    protected final By emailField = By.xpath("//input[@name='email']");
    protected final By phoneField = By.xpath("//input[@name='phone']");
//    protected final By exclusiveMemberBenefitsCheckBox = By.xpath("//input[@data-ux='InputCheckbox']/following-sibling::div[@data-ux='Element']");
    protected final By createAccountBtn = By.xpath("//button[@data-ux='ButtonPrimary']");
    protected final By confirmationHeading = By.xpath("//h4[@data-ux='Heading']");
    protected final By confirmationMessage = By.xpath("//p[@data-aid='CREATE_ACCOUNT_DESCRIPTION_REND']");
}
