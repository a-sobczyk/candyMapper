package org.candyMapper;

import org.candyMapper.pages.NavBarPage;
import org.candyMapper.steps.MainScreenPopupSteps;
import org.candyMapper.steps.NavBarSteps;
import org.candyMapper.steps.RegistrationSteps;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {

    final MainScreenPopupSteps mainScreenPopupSteps = new MainScreenPopupSteps();
    final NavBarSteps navBarSteps = new NavBarSteps();
    final RegistrationSteps registrationSteps = new RegistrationSteps();

    @Test
    public void newUserRegistration() {
        mainScreenPopupSteps.closePopup();
        navBarSteps.newUserRegistrationButtonClick();
        registrationSteps.registrationLinkClick();
        registrationSteps.fillRegistrationFields();
        registrationSteps.exclusiveMemberBenefitsCheckBoxClick();
        registrationSteps.createAccountBtnClick();
        registrationSteps.checkConfirmationHeadingAndConfirmationText();
    }
}
