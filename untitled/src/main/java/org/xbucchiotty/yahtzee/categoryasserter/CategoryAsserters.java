package org.xbucchiotty.yahtzee.categoryasserter;

import static org.xbucchiotty.yahtzee.categoryasserter.CategoryAsserter.*;
import static org.xbucchiotty.yahtzee.categoryasserter.SerieAsserter.Serie;
import static org.xbucchiotty.yahtzee.categoryasserter.StraightAsserter.LARGE_STRAIGHT;
import static org.xbucchiotty.yahtzee.categoryasserter.StraightAsserter.SMALL_STRAIGHT;

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
        return new KindAsserter(PAIR);
    }

    public static CategoryAsserter threeOfKind() {
        return new KindAsserter(THREE_OF_KIND);
    }

    public static CategoryAsserter fourOfKind() {
        return new KindAsserter(FOUR_OF_KIND);
    }

    public static CategoryAsserter twoPairs() {
        return new TwoPairsAsserter();
    }

    public static CategoryAsserter fullHouse() {
        return new FullHouseAsserter();
    }

    public static CategoryAsserter smallStraight() {
        return new StraightAsserter(SMALL_STRAIGHT);
    }

    public static CategoryAsserter largeStraight() {
        return new StraightAsserter(LARGE_STRAIGHT);
    }
}
