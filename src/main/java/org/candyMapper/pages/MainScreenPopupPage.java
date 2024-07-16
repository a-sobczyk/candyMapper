package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainScreenPopupPage extends BaseTest {
    @FindBy(id = "popup-widget238491-close-icon")
    public WebElement closeIconButton;
    @FindBy(xpath = "//div[@data-ux='Block']/a[text()='FIND MY CANDY!']")
    public WebElement findMyCandyButton;
}