package org.candyMapper.pages;

import lombok.Getter;
import org.candyMapper.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HalloweenSpecialPodcastPage extends BaseTest {

    @FindBy(className = "main-title")
    public WebElement mainTitle;
}
