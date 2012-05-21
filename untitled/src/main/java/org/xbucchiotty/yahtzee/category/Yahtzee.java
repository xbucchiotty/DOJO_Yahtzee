package org.xbucchiotty.yahtzee.category;

import com.google.common.base.Predicate;
import org.xbucchiotty.yahtzee.Functions;
import org.xbucchiotty.yahtzee.score.Score;

import static com.google.common.collect.Iterables.all;
import static java.util.Arrays.asList;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 09:13
 */
public class Yahtzee implements Category {


    public static final int SCORE = 50;
    public static final int ZERO = 0;

    boolean isRuleStatisfied(Score score) {
        return all(asList(score.getScores()), Yahtzee.sameScore());
    }

    static Predicate<Integer> sameScore() {
        return Functions.sameElement();
    }

    @Override
    public Integer register(Score score) {
        return isRuleStatisfied(score) ? SCORE : ZERO;
    }
}
