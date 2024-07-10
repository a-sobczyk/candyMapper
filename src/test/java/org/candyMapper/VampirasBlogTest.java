package org.candyMapper;

import org.candyMapper.steps.MainScreenPopupSteps;
import org.candyMapper.steps.NavBarSteps;
import org.candyMapper.steps.VampirasBlogSteps;
import org.junit.jupiter.api.Test;

public class VampirasBlogTest extends BaseTest {

    private final MainScreenPopupSteps mainScreenPopupSteps = new MainScreenPopupSteps();
    private final NavBarSteps navBarSteps = new NavBarSteps();
    private final VampirasBlogSteps vampirasBlogSteps = new VampirasBlogSteps();

    @Test
    public void goToVampirasBlogAndCheckFirstArticle() {
        mainScreenPopupSteps.closePopup();
        navBarSteps.navMoreBtnClick();
        navBarSteps.vampirasBlogBtnClick();
        vampirasBlogSteps.continueReadingLinkClick();
        vampirasBlogSteps.checkBlogMainHeadingAndBlogContentText();
    }
}
