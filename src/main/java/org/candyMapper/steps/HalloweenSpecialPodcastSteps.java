package org.candyMapper.steps;

import org.candyMapper.BaseTest;
import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.HalloweenSpecialPodcastPage;
import org.candyMapper.pages.MainScreenPopupPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class HalloweenSpecialPodcastSteps extends BaseTest {

    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();
    private final SoftAssert softAssert = new SoftAssert();
    private final HalloweenSpecialPodcastPage halloweenSpecialPodcastPage;

    public HalloweenSpecialPodcastSteps() {
        this.halloweenSpecialPodcastPage = new HalloweenSpecialPodcastPage();
        PageFactory.initElements(driver, this.halloweenSpecialPodcastPage);
    }

    public String getMainTitle() {
        log.info("Pobranie elementu w nowej przeglądarce: " + halloweenSpecialPodcastPage.mainTitle);
        waits.waitElementToBePresent(halloweenSpecialPodcastPage.mainTitle);
        return pageOperators.getText(halloweenSpecialPodcastPage.mainTitle);
    }

    public void checkTitleOnHalloweenSpecialPodcastPage(String title) {
        log.info("Sprawdzenie tytulu strony");
        softAssert.assertEquals(title, "Halloween Special 2023 with Paul Grossman and Larry Goddard",
                "Incorrect title on Halloween Special Podcast Page");
        softAssert.assertAll();
    }
}
