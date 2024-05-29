package org.candyMapper;

import org.candyMapper.steps.MainScreenPopupSteps;
import org.candyMapper.steps.MainScreenSteps;
import org.junit.jupiter.api.Test;

public class SendMessageTest extends BaseTest {

    final MainScreenPopupSteps mainScreenPopupSteps = new MainScreenPopupSteps();
    final MainScreenSteps mainScreenSteps = new MainScreenSteps();

    @Test
    public void closePopupAndSendContactUsForm() {
        mainScreenPopupSteps.closePopup();
        mainScreenSteps.fillNameField();
        mainScreenSteps.fillEmailField();
        mainScreenSteps.fillTextAreaField();
        mainScreenSteps.sendMessageBtnClick();
        mainScreenSteps.conformationMessageAssertion();
    }
}
