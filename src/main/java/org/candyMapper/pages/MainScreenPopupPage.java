package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;


public class MainScreenPopupPage extends BaseTest {

    protected final By closeIconButton = By.id("popup-widget111379-close-icon");
    protected final By findMyCandyButton = By.xpath("//div[@data-ux='Block']/a[text()='FIND MY CANDY!']");
}