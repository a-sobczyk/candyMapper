package org.candyMapper.steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.MainScreenPage;
import org.testng.asserts.SoftAssert;

public class MainScreenSteps extends MainScreenPage {

    PageOperators pageOperators = new PageOperators();
    Waits waits = new Waits();
    SoftAssert softAssert = new SoftAssert();

    public void fillNameField() {
        log.info("Wypelniam pole \"Name\".");
        pageOperators.scrollToElement(sendMessageBtn);
        pageOperators.javaScriptButtonClickAndSendText(nameField, "Tester");
    }

    public void fillEmailField() {
        log.info("Wypelniam pole \"Email\".");
        pageOperators.javaScriptButtonClickAndSendText(emailField, "email@test.pl");
    }

    public void fillTextAreaField() {
        log.info("Wypelniam pole \"Message\".");
        pageOperators.javaScriptButtonClickAndSendText(textAreaField, RandomStringUtils.randomAlphabetic(100));
    }

    public void sendMessageBtnClick() {
        log.info("Przed kliknieciem przycisku \"SEND\".");
        waits.millisecondsWait(2000);
        pageOperators.javaScriptButtonClick(sendMessageBtn);
        log.info("Po kliknieciu przycisku \"SEND\".");
    }

    public void conformationMessageAssertion() {
        log.info("Wykonanie assercji po wyslaniu wiadomosci.");
        waits.waitElementToBePresent(confirmationMessage);
        softAssert.assertEquals(pageOperators.getText(confirmationMessage),
                "Thank you for your inquiry! We will get back to you within 48 hours.",
                "Incorrect confirmation message.");
        softAssert.assertAll();
    }

    public void checkIfMessageToCompleteEmailFieldIsAppeared() {
        log.info("Wykonanie assercji - powinien pojawic sie komunikat o koniecznosci uzupelnienia pola email.");
        waits.waitElementToBePresent(invalidEmailAddressMessage);
        softAssert.assertEquals(pageOperators.getText(invalidEmailAddressMessage),
                "Please enter a valid email address.",
                "Incorrect email validation message message.");
        softAssert.assertAll();
    }
}
