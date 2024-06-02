package org.candyMapper.steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.helpers.enums.County;
import org.candyMapper.pages.MainScreenPage;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainScreenSteps extends MainScreenPage {

    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();
    private final SoftAssert softAssert = new SoftAssert();

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

    public List<WebElement> getDropdownList() {
        log.info("Pobranie wszystkich elementów listy rozwijanej.");
        waits.waitElementToBePresent(ConnectWithSocialMediaTxt);
        pageOperators.scrollToElement(ConnectWithSocialMediaTxt);
        WebElement iframe  = driver.findElement(countyIFrame);
        driver.switchTo().frame(iframe);
        return pageOperators.findElements(countyDropdownList);
    }

    public void checkCountyNamesAndDuplicationsInDropdownList(List<WebElement> dropdownList) {
        log.info("Sprawdzenie unikalnosci nazw oraz ilosci wystapien nazw w dropdown menu.");
        Set<String> set = new HashSet<>();
        for(WebElement element: dropdownList) {
            if(!element.getText().equals("Select a County")) {
                softAssert.assertTrue(set.add(element.getText()), "Duplicate value in drop-down menu: " + element.getText());
            }
        }
        for(County county : County.values()) {
            softAssert.assertTrue(set.contains(county.getText()), "Dropdown menu does not include: " + county.getText());
        }
        softAssert.assertAll();
    }
}
