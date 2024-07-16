package org.candyMapper.steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.RegistrationPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class RegistrationSteps extends RegistrationPage {

    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();
    private final SoftAssert softAssert = new SoftAssert();
    private final RegistrationPage registrationPage;

    public RegistrationSteps() {
        this.registrationPage = new RegistrationPage();
        PageFactory.initElements(driver, this.registrationPage);
    }

    public void registrationLinkClick() {
        log.info("Przed kliknieciem linku \"Create account\".");
        waits.waitElementToBePresent(registrationPage.createAccountLink);
        pageOperators.javaScriptButtonClick(registrationPage.createAccountLink);
    }

    public void fillRegistrationFields() {
        log.info("Wypełnianie formularza rejestracyjnego.");
        waits.waitElementToBePresent(registrationPage.createAccountBtn);
        pageOperators.scrollToElement(registrationPage.createAccountBtn);
        pageOperators.javaScriptButtonClickAndSendText(registrationPage.firstNameField, "Tester");
        pageOperators.javaScriptButtonClickAndSendText(registrationPage.lastNameField, "Automation");
        pageOperators.javaScriptButtonClickAndSendText(registrationPage.emailField, "email@test.pl");
        pageOperators.javaScriptButtonClickAndSendText(registrationPage.phoneField, RandomStringUtils.randomNumeric(9));
    }

    public void createAccountBtnClick() {
        log.info("Przed kliknieciem przycisku \"CREATE ACCOUNT\".");
        pageOperators.javaScriptButtonClick(registrationPage.createAccountBtn);
    }

    public void checkConfirmationHeadingAndConfirmationText() {
        log.info("Sprawdzenie poprawnosci wyswietlanych wiadomosci po zakonczeniu rejestracji.");
        waits.waitElementToBePresent(registrationPage.confirmationHeading);
        softAssert.assertEquals(pageOperators.getText(registrationPage.confirmationHeading),
                "Check your email", "Invalid confirmation heading.");
        softAssert.assertEquals(pageOperators.getText(registrationPage.confirmationMessage),
                "You're almost there! We sent an email to email@test.pl with a link to activate your account." +
                        " Please check your email and click the activation link.", "Invalid confirmation message.");
        softAssert.assertAll();
    }
}
