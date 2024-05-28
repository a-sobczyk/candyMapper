package org.candyMapper;

import org.candyMapper.pages.MainScreenPage;
import org.candyMapper.pages.MainScreenPopupPage;
import org.junit.jupiter.api.Test;

public class FirstTest extends BaseTest {

    final MainScreenPopupPage mainScreenPopupPage = new MainScreenPopupPage();
    final MainScreenPage mainScreenPage = new MainScreenPage();
    @Test
    public void closePopupAndSendContactUsForm() {
       mainScreenPopupPage.closePopup();
       mainScreenPage.fillNameField();
       mainScreenPage.fillEmailField();
       mainScreenPage.fillTextAreaField();
    }
}
