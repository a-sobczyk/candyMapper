package org.candyMapper.steps;

import org.candyMapper.helpers.PageOperators;
import org.candyMapper.pages.MainScreenPage;
import org.candyMapper.pages.MainScreenPopupPage;
import org.openqa.selenium.support.PageFactory;

public class MainScreenPopupSteps extends MainScreenPopupPage {

    private final PageOperators pageOperators = new PageOperators();
    private final MainScreenPopupPage mainScreenPopupPage;

    public MainScreenPopupSteps() {
        this.mainScreenPopupPage = new MainScreenPopupPage();
        PageFactory.initElements(driver, this.mainScreenPopupPage);
    }

    public void closePopup() {
        pageOperators.buttonClick(mainScreenPopupPage.closeIconButton);
        log.info("Zamknięcie popup'a.");
    }
}
