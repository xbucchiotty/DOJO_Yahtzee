package org.xbucchiotty.yahtzee.categoryasserter;

import static org.xbucchiotty.yahtzee.categoryasserter.SerieAsserter.Serie;

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

    public static CategoryAsserter serie(Serie serie) {
        return new SerieAsserter(serie);
    }

    public static CategoryAsserter pair() {
        return new PairAsserter();
    }
}
