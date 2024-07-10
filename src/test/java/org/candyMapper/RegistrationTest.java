package org.candyMapper;

import org.candyMapper.pages.NavBarPage;
import org.candyMapper.steps.MainScreenPopupSteps;
import org.candyMapper.steps.NavBarSteps;
import org.candyMapper.steps.RegistrationSteps;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {

    private final MainScreenPopupSteps mainScreenPopupSteps = new MainScreenPopupSteps();
    private final NavBarSteps navBarSteps = new NavBarSteps();
    private final RegistrationSteps registrationSteps = new RegistrationSteps();

    @Test
    public void newUserRegistration() {
        mainScreenPopupSteps.closePopup();
        navBarSteps.newUserRegistrationButtonClick();
        registrationSteps.registrationLinkClick();
        registrationSteps.fillRegistrationFields();
        registrationSteps.createAccountBtnClick();
        registrationSteps.checkConfirmationHeadingAndConfirmationText();
    }
}
