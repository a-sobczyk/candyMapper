package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;


public class MainScreenPopupPage extends BaseTest {

    By closeIconButton = By.id("popup-widget111379-close-icon");
    By findMyCandyButton = By.xpath("//div[@data-ux='Block']/a[text()='FIND MY CANDY!']");

    public void closePopup() {
        buttonClick(closeIconButton);
    }
}
