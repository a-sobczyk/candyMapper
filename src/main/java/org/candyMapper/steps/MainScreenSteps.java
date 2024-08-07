package org.candyMapper.steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.helpers.enums.County;
import org.candyMapper.pages.MainScreenPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainScreenSteps extends MainScreenPage {

    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();
    private final MainScreenPage mainScreenPage;
    private final SoftAssert softAssert = new SoftAssert();

    public MainScreenSteps() {
        this.mainScreenPage = new MainScreenPage();
        PageFactory.initElements(driver, this.mainScreenPage);
    }

    public void fillNameField() {
        log.info("Wypelniam pole \"Name\".");
        pageOperators.scrollToElement(mainScreenPage.sendMessageBtn);
        pageOperators.javaScriptButtonClickAndSendText(mainScreenPage.nameField, "Tester");
    }

    public void fillEmailField() {
        log.info("Wypelniam pole \"Email\".");
        pageOperators.javaScriptButtonClickAndSendText(mainScreenPage.emailField, "email@test.pl");
    }

    public void fillTextAreaField() {
        log.info("Wypelniam pole \"Message\".");
        pageOperators.javaScriptButtonClickAndSendText(mainScreenPage.textAreaField,
                RandomStringUtils.randomAlphabetic(100));
    }

    public void sendMessageBtnClick() {
        log.info("Przed kliknieciem przycisku \"SEND\".");
        waits.millisecondsWait(2000);
        pageOperators.javaScriptButtonClick(mainScreenPage.sendMessageBtn);
        log.info("Po kliknieciu przycisku \"SEND\".");
    }

    public void conformationMessageAssertion() {
        log.info("Wykonanie assercji po wyslaniu wiadomosci.");
        waits.waitElementToBePresent(mainScreenPage.confirmationMessage);
        softAssert.assertEquals(pageOperators.getText(mainScreenPage.confirmationMessage),
                "Thank you for your inquiry! We will get back to you within 48 hours.",
                "Incorrect confirmation message.");
        softAssert.assertAll();
    }

    public void checkIfMessageToCompleteEmailFieldIsAppeared() {
        log.info("Wykonanie assercji - powinien pojawic sie komunikat o koniecznosci uzupelnienia pola email.");
        waits.waitElementToBePresent(mainScreenPage.invalidEmailAddressMessage);
        softAssert.assertEquals(pageOperators.getText(mainScreenPage.invalidEmailAddressMessage),
                "Please enter a valid email address.",
                "Incorrect email validation message message.");
        softAssert.assertAll();
    }

    public List<WebElement> getDropdownList() {
        log.info("Pobranie wszystkich elementów listy rozwijanej.");
        waits.waitElementToBePresent(mainScreenPage.ConnectWithSocialMediaTxt);
        pageOperators.scrollToElement(mainScreenPage.ConnectWithSocialMediaTxt);
        pageOperators.scrollToElement(mainScreenPage.dollarAmountText);
        waits.waitElementToBePresent(mainScreenPage.countyIFrame);
        driver.switchTo().frame(mainScreenPage.countyIFrame);
        return mainScreenPage.countyDropdownList;
    }

    public void checkCountyNamesAndDuplicationsInDropdownList(List<WebElement> dropdownList) {
        log.info("Sprawdzenie unikalnosci nazw oraz ilosci wystapien nazw w dropdown menu.");
        Set<String> set = new HashSet<>();
        for (WebElement element : dropdownList) {
            if (!element.getText().equals("Select a County")) {
                softAssert.assertTrue(set.add(element.getText()), "Duplicate value in drop-down menu: " + element.getText());
            }
        }
        for (County county : County.values()) {
            softAssert.assertTrue(set.contains(county.getText()), "Dropdown menu does not include: " + county.getText());
        }
        softAssert.assertAll();
    }

    public void halloweenPodcastLinkClick() {
        waits.waitElementToBePresent(mainScreenPage.halloweenPodcastLink);
        pageOperators.scrollToElement(mainScreenPage.halloweenPodcastLink);
        pageOperators.javaScriptButtonClick(mainScreenPage.halloweenPodcastLink);
    }

    public void changeTabToHalloweenSpecialPodcast() {
        pageOperators.changeTab(1);
    }
}
