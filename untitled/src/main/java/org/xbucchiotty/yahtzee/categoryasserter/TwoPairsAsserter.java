package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.collect.Multiset;
import org.xbucchiotty.yahtzee.Roll;

import java.util.Set;

import static com.google.common.collect.Sets.filter;
import static org.xbucchiotty.utils.function.FunctionHelper.map;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.*;
import static org.xbucchiotty.yahtzee.Points.ZERO;
import static org.xbucchiotty.yahtzee.Predicates.onCountEqualTo;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 18:53
 */
public class TwoPairsAsserter implements CategoryAsserter {

    @Override
    public Integer givePoints(Roll roll) {
        Set<Multiset.Entry<Integer>> pairs = filter(groupRollByValue().convert(roll),
                onCountEqualTo(PAIR));

        final Integer result;

        if (pairs.size() == TWO) {
            result = reduce(
                    sum(),
                    map(
                            extractPoints(),
                            pairs
                    )
            ).or(ZERO);
        } else {
            result = ZERO;
        }

        return result;
    }
}
