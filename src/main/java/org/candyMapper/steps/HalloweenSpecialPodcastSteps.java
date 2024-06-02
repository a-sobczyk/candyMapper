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
        waits.waitElementToBePresent(mainTitle);
        return pageOperators.getText(mainTitle);
    }

    public void checkTitleOnHalloweenSpecialPodcastPage(String title) {
        softAssert.assertEquals(title, "Halloween Special 2023 with Paul Grossman and Larry Goddard",
                "Incorrect title on Halloween Special Podcast Page");
        softAssert.assertAll();
    }
}
