package org.candyMapper.steps;

import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.NavBarPage;

public class NavBarSteps extends NavBarPage {
    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();

    public void newUserRegistrationButtonClick() {
        log.info("Przed kliknieciem przycisku \"JOIN US\".");
        waits.waitElementToBePresent(navBarJoinUsBtn);
        pageOperators.javaScriptButtonClick(navBarJoinUsBtn);
    }

    public void navMoreBtnClick() {
        log.info("Klikam w przycisk \"More\".");
        waits.waitElementToBePresent(navMoreBtn);
        pageOperators.javaScriptButtonClick(navMoreBtn);
    }

    public void vampirasBlogBtnClick() {
        log.info("Klikam w przycisk \"Vampira's Blog\"");
        waits.waitElementToBePresent(vampirasBlogBtn);
        pageOperators.javaScriptButtonClick(vampirasBlogBtn);
    }
}
