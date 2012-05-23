package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import org.xbucchiotty.utils.function.Converter;
import org.xbucchiotty.utils.function.Reducer;
import org.xbucchiotty.yahtzee.Functions;
import org.xbucchiotty.yahtzee.Roll;

import static com.google.common.base.Predicates.equalTo;
import static com.google.common.collect.Sets.filter;
import static org.xbucchiotty.utils.function.FunctionHelper.map;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
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
        ImmutableMultiset<Integer> rollsGroupByRollValue = ImmutableMultiset.<Integer>builder().addAll(roll.getRolls()).build();

        return
                reduce(
                        highestPoints(),
                        map(
                                extractPoints(),
                                filter(
                                        rollsGroupByRollValue.entrySet(),
                                        onCountEqualTo(requiredCount)
                                )
                        )
                ).or(ZERO);
    }

    private Reducer<Integer, Optional<Integer>> highestPoints() {
        return Functions.getHighest();
    }

    static Converter<Multiset.Entry<Integer>, Integer> extractPoints() {
        return new Converter<Multiset.Entry<Integer>, Integer>() {
            @Override
            public Integer convert(Multiset.Entry<Integer> input) {
                return input.getElement() * input.getCount();
            }
        };
    }

    static Predicate<Multiset.Entry<Integer>> onCountEqualTo(final int reference) {
        return new Predicate<Multiset.Entry<Integer>>() {
            @Override
            public boolean apply(Multiset.Entry<Integer> collectionEntry) {
                return equalTo(reference).apply(collectionEntry.getCount());
            }
        };
    }

}
