package org.candyMapper.pages;

import org.candyMapper.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VampirasBlogPage extends BaseTest {
    @FindBy(xpath = "//span[text()='Continue Reading']")
    public WebElement continueReadingLink;
    @FindBy(xpath = "//h3[@data-ux='BlogMainHeading']")
    public WebElement blogMainHeadingText;
    @FindBy(xpath = "//div[@data-ux='BlogContent']/p/span")
    public WebElement blogContent;
}
