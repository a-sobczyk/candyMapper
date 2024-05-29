package org.candyMapper.steps;

import org.candyMapper.helpers.PageOperators;
import org.candyMapper.pages.MainScreenPopupPage;

public class MainScreenPopupSteps extends MainScreenPopupPage {

    PageOperators pageOperators = new PageOperators();

    public void closePopup() {
        pageOperators.buttonClick(closeIconButton);
        log.info("Zamknięcie popup'a.");
    }
}
