package org.xbucchiotty.yahtzee.category;

import com.google.common.base.Predicate;
import org.xbucchiotty.yahtzee.score.Score;

import javax.annotation.Nullable;

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
        return new Predicate<Integer>() {
            private Integer firstElement;

            @Override
            public boolean apply(@Nullable Integer integer) {
                if (firstElement == null) {
                    firstElement = integer;

                }
                return firstElement != null && firstElement.equals(integer);
            }

        };
    }

    @Override
    public Integer register(Score score) {
        return isRuleStatisfied(score) ? SCORE : ZERO;
    }
}
