package org.candyMapper.steps;

import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.NavBarPage;
import org.openqa.selenium.support.PageFactory;

public class NavBarSteps extends NavBarPage {
    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();
    private final NavBarPage navBarPage;

    public NavBarSteps() {
        this.navBarPage = new NavBarPage();
        PageFactory.initElements(driver, this.navBarPage);
    }

    public void newUserRegistrationButtonClick() {
        log.info("Przed kliknieciem przycisku \"JOIN US\".");
        waits.waitElementToBePresent(navBarPage.navBarJoinUsBtn);
        pageOperators.javaScriptButtonClick(navBarPage.navBarJoinUsBtn);
    }

    public void navMoreBtnClick() {
        log.info("Klikam w przycisk \"More\".");
        waits.waitElementToBePresent(navBarPage.navMoreBtn);
        pageOperators.javaScriptButtonClick(navBarPage.navMoreBtn);
    }

    public void vampirasBlogBtnClick() {
        log.info("Klikam w przycisk \"Vampira's Blog\"");
        waits.waitElementToBePresent(navBarPage.vampirasBlogBtn);
        pageOperators.javaScriptButtonClick(navBarPage.vampirasBlogBtn);
    }
}
