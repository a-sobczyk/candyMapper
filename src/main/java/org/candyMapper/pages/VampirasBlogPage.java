package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;

public class VampirasBlogPage extends BaseTest {

    protected final By continueReadingLink = By.xpath("//span[text()='Continue Reading']");
    protected final By blogMainHeadingText = By.xpath("//h3[@data-ux='BlogMainHeading']");
    protected final By blogContent = By.xpath("//div[@data-ux='BlogContent']/p/span");
}
