package org.candyMapper.steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.RegistrationPage;
import org.testng.asserts.SoftAssert;

public class RegistrationSteps extends RegistrationPage {

    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();
    private final SoftAssert softAssert = new SoftAssert();

    public void registrationLinkClick() {
        log.info("Przed kliknieciem linku \"Create account\".");
        waits.waitElementToBePresent(createAccountLink);
        pageOperators.javaScriptButtonClick(createAccountLink);
    }

    public void fillRegistrationFields() {
        log.info("Wypełnianie formularza rejestracyjnego.");
        waits.waitElementToBePresent(createAccountBtn);
        pageOperators.scrollToElement(createAccountBtn);
        pageOperators.javaScriptButtonClickAndSendText(firstNameField, "Tester");
        pageOperators.javaScriptButtonClickAndSendText(lastNameField, "Automation");
        pageOperators.javaScriptButtonClickAndSendText(emailField, "email@test.pl");
        pageOperators.javaScriptButtonClickAndSendText(phoneField, RandomStringUtils.randomNumeric(9));
    }

    public void createAccountBtnClick() {
        log.info("Przed kliknieciem przycisku \"CREATE ACCOUNT\".");
        pageOperators.javaScriptButtonClick(createAccountBtn);
    }

    public void checkConfirmationHeadingAndConfirmationText() {
        log.info("Sprawdzenie poprawnosci wyswietlanych wiadomosci po zakonczeniu rejestracji.");
        waits.waitElementToBePresent(confirmationHeading);
        softAssert.assertEquals(pageOperators.getText(confirmationHeading), "Check your email", "Invalid confirmation heading.");
        softAssert.assertEquals(pageOperators.getText(confirmationMessage),
                "You're almost there! We sent an email to email@test.pl with a link to activate your account." +
                        " Please check your email and click the activation link.", "Invalid confirmation message.");
        softAssert.assertAll();
    }
}
