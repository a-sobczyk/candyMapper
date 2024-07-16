package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBarPage extends BaseTest {
    @FindBy(xpath = "//a[text()='JOIN US' and @data-ux='NavLink']")
    public WebElement navBarJoinUsBtn;
    @FindBy(xpath = "//a[@data-aid='NAV_MORE']")
    public WebElement navMoreBtn;
    @FindBy(xpath = "//li[@data-ux='ListItem']/a[@href='/vampiras-blog']")
    public WebElement vampirasBlogBtn;

}
