package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.collect.ImmutableList;
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
 * Time: 19:19
 */
public class FullHouseAsserter implements CategoryAsserter {

    @Override
    public Integer givePoints(Roll roll) {
        Set<Multiset.Entry<Integer>> pairs = filter(groupRollByValue().convert(roll),
                onCountEqualTo(PAIR));
        Set<Multiset.Entry<Integer>> threeOfKinds = filter(groupRollByValue().convert(roll),
                onCountEqualTo(THREE_OF_KIND));


        final Integer result;
        if (!pairs.isEmpty() && !threeOfKinds.isEmpty()) {
            result = reduce(
                    sum(),
                    ImmutableList.<Integer>builder()
                            .addAll(
                                    map(extractPoints(), pairs)
                            )
                            .addAll(map(extractPoints(), threeOfKinds)
                            ).build()
            ).or(ZERO);
        } else {
            result = ZERO;
        }


        return result;
    }
}
