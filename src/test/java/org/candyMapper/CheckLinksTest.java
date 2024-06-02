package org.candyMapper;

import org.candyMapper.steps.HalloweenSpecialPodcastSteps;
import org.candyMapper.steps.MainScreenPopupSteps;
import org.candyMapper.steps.MainScreenSteps;
import org.junit.jupiter.api.Test;

public class CheckLinksTest extends BaseTest {
    private final MainScreenPopupSteps mainScreenPopupSteps = new MainScreenPopupSteps();
    private final MainScreenSteps mainScreenSteps = new MainScreenSteps();
    private final HalloweenSpecialPodcastSteps halloweenSpecialPodcastSteps = new HalloweenSpecialPodcastSteps();

    @Test
    public void checkHalloweenLinkTest() {
        mainScreenPopupSteps.closePopup();
        mainScreenSteps.halloweenPodcastLinkClick();
        mainScreenSteps.changeTabToHalloweenSpecialPodcast();
        String title = halloweenSpecialPodcastSteps.getMainTitle();
        halloweenSpecialPodcastSteps.checkTitleOnHalloweenSpecialPodcastPage(title);
    }
}
