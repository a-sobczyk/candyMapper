package org.candyMapper.steps;

import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.HalloweenSpecialPodcastPage;
import org.testng.asserts.SoftAssert;

public class HalloweenSpecialPodcastSteps extends HalloweenSpecialPodcastPage {

    PageOperators pageOperators = new PageOperators();
    Waits waits = new Waits();
    SoftAssert softAssert = new SoftAssert();

    public String getMainTitle() {
        log.info("Pobranie elementu w nowej przeglądarce: " + mainTitle);
        waits.waitElementToBePresent(mainTitle);
        return pageOperators.getText(mainTitle);
    }

    public void checkTitleOnHalloweenSpecialPodcastPage(String title) {
        log.info("Sprawdzenie tytulu strony");
        softAssert.assertEquals(title, "Halloween Special 2023 with Paul Grossman and Larry Goddard",
                "Incorrect title on Halloween Special Podcast Page");
        softAssert.assertAll();
    }
}
