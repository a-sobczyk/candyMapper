package org.candyMapper.steps;

import org.candyMapper.helpers.PageOperators;
import org.candyMapper.helpers.Waits;
import org.candyMapper.pages.VampirasBlogPage;
import org.testng.asserts.SoftAssert;

public class VampirasBlogSteps extends VampirasBlogPage {

    private final PageOperators pageOperators = new PageOperators();
    private final Waits waits = new Waits();
    private final SoftAssert softAssert = new SoftAssert();

    public void continueReadingLinkClick() {
        log.info("Klikam w link \"Continue Reading\".");
        waits.waitElementToBePresent(continueReadingLink);
        pageOperators.javaScriptButtonClick(continueReadingLink);
    }

    public void checkBlogMainHeadingAndBlogContentText() {
        softAssert.assertEquals(pageOperators.getText(blogMainHeadingText), "CandyMapper is under new management!",
                "Invalid main heading text.");
        softAssert.assertEquals(pageOperators.getText(blogContent),
                " Vampira has taken over Dorothy Gale's duties as Master Blog Poster. ",
                "Invalid blog content text.");
        softAssert.assertAll();
    }
}
