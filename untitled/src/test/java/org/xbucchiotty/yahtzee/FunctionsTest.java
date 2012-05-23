package org.xbucchiotty.yahtzee;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Multiset;
import org.junit.Test;
import org.xbucchiotty.utils.function.Reducer;

import java.util.Set;

import static com.google.common.collect.Multisets.immutableEntry;
import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 18:50
 */
public class FunctionsTest {
    @Test
    public void testSameElement() {
        Predicate<Integer> sameElement = Functions.sameElement();
        assertThat(sameElement.apply(1)).isTrue();
        assertThat(sameElement.apply(1)).isTrue();
        assertThat(sameElement.apply(2)).isFalse();
    }

    @Test
    public void testSum() {
        Reducer<Integer, Optional<Integer>> sumOperator = Functions.sum();
        sumOperator.agrege(1);
        sumOperator.agrege(2);
        sumOperator.agrege(3);
        assertThat(sumOperator.getResult().get()).isEqualTo(6);
    }

    @Test
    public void testGetHighestElement() {
        Reducer<Comparable, Optional<Comparable>> highest = Functions.getHighest();
        highest.agrege(1);
        highest.agrege(2);
        highest.agrege(4);
        highest.agrege(-1);

        assertThat(highest.getResult().get()).isEqualTo(4);
    }

    @Test
    public void testExtractRoll() {
        assertThat(Functions.extractPoints().convert(getData(1, 5))).isEqualTo(5);
    }

    @Test
    public void testGroupRollByValue() {
        Set<Multiset.Entry<Integer>> result = Functions.groupRollByValue().convert(new Roll(1, 1, 2, 3, 4));
        assertThat(result)
                .isNotNull()
                .hasSize(4)
                .contains(
                        getData(1, 2),
                        getData(2, 1),
                        getData(3, 1),
                        getData(4, 1)
                );
    }

    private Multiset.Entry<Integer> getData(Integer element, int count) {
        return immutableEntry(element, count);
    }
}
