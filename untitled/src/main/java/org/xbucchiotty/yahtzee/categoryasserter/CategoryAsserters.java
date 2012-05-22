package org.xbucchiotty.yahtzee.categoryasserter;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 18:46
 */
public class CategoryAsserters {

    public static CategoryAsserter yahtzee() {
        return new YahtzeeAsserter();
    }

    public static CategoryAsserter chance() {
        return new ChanceAsserter();
    }
}
