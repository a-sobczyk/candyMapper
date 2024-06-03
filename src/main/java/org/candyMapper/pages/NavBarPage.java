package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;

public class NavBarPage extends BaseTest {
    protected final By navBarJoinUsBtn = By.xpath("//a[text()='JOIN US' and @data-ux='NavLink']");
}
