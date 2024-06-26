package org.candyMapper;

import org.candyMapper.steps.MainScreenPopupSteps;
import org.candyMapper.steps.MainScreenSteps;
import org.junit.jupiter.api.Test;

public class SendMessageTest extends BaseTest {

    private final MainScreenPopupSteps mainScreenPopupSteps = new MainScreenPopupSteps();
    private final MainScreenSteps mainScreenSteps = new MainScreenSteps();

    @Test
    public void closePopupAndSendContactUsForm() {
        mainScreenPopupSteps.closePopup();
        mainScreenSteps.fillNameField();
        mainScreenSteps.fillEmailField();
        mainScreenSteps.fillTextAreaField();
        mainScreenSteps.sendMessageBtnClick();
        mainScreenSteps.conformationMessageAssertion();
    }

    @Test
    public void iTrySendingMessageWithoutEmailField_ThenTestResultsMessageAboutNeedToCompleteEmailField() {
        mainScreenPopupSteps.closePopup();
        mainScreenSteps.fillNameField();
        mainScreenSteps.fillTextAreaField();
        mainScreenSteps.sendMessageBtnClick();
        mainScreenSteps.checkIfMessageToCompleteEmailFieldIsAppeared();
    }
}
