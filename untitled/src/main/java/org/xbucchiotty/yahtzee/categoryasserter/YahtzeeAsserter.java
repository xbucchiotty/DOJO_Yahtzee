package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.base.Predicate;
import org.xbucchiotty.yahtzee.Functions;
import org.xbucchiotty.yahtzee.Points;
import org.xbucchiotty.yahtzee.Roll;

import static com.google.common.collect.Iterables.all;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 09:13
 */
public class YahtzeeAsserter implements CategoryAsserter {


    private static final int SCORE = 50;

    boolean isRuleStatisfied(Roll roll) {
        return all(roll.getRolls(), sameScore());
    }

    static Predicate<Integer> sameScore() {
        return Functions.sameElement();
    }

    @Override
    public Integer givePoints(Roll roll) {
        return isRuleStatisfied(roll) ? SCORE : Points.ZERO;
    }
}
