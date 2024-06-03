package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;

public class NavBarPage extends BaseTest {
    protected final By navBarJoinUsBtn = By.xpath("//a[text()='JOIN US' and @data-ux='NavLink']");
    protected final By navMoreBtn = By.xpath("//a[@data-aid='NAV_MORE']");
    protected final By vampirasBlogBtn = By.xpath("//li[@data-ux='ListItem']/a[@href='/vampiras-blog']");

}
