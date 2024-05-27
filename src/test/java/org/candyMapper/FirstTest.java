package org.candyMapper;

import org.candyMapper.pages.MainScreenPopupPage;
import org.junit.jupiter.api.Test;

public class FirstTest extends BaseTest {

    MainScreenPopupPage mainScreenPopupPage = new MainScreenPopupPage();
    @Test
    public void closePopupAndSendContactUsForm() {
       System.out.println(driver.getTitle());
       mainScreenPopupPage.closePopup();
    }
}
