package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.base.Optional;
import org.xbucchiotty.utils.function.Reducer;
import org.xbucchiotty.yahtzee.Functions;
import org.xbucchiotty.yahtzee.Predicates;
import org.xbucchiotty.yahtzee.Roll;

import static com.google.common.collect.Sets.filter;
import static org.xbucchiotty.utils.function.FunctionHelper.map;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.*;
import static org.xbucchiotty.yahtzee.Points.ZERO;

/**
 * User: xbucchiotty
 * Date: 22/05/12
 * Time: 17:14
 */
public class KindAsserter implements CategoryAsserter {

    private final int numberOfKindRequested;

    public KindAsserter(int numberOfKindRequested) {
        this.numberOfKindRequested = numberOfKindRequested;
    }

    @Override
    public Integer givePoints(Roll roll) {
        return highestRollWithRequiredCount(roll, numberOfKindRequested);
    }

    private Integer highestRollWithRequiredCount(Roll roll, int requiredCount) {
        return
                reduce(
                        highestPoints(),
                        map(
                                extractPoints(),
                                filter(
                                        groupRollByValue().convert(roll),
                                        Predicates.onCountEqualTo(requiredCount)
                                )
                        )
                ).or(ZERO);
    }

    private Reducer<Integer, Optional<Integer>> highestPoints() {
        return Functions.getHighest();
    }
}
