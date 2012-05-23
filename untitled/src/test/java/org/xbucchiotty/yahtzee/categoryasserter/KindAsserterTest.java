package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.collect.Multiset;
import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static com.google.common.collect.Multisets.immutableEntry;
import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 08:01
 */
public class KindAsserterTest {

    @Test
    public void testOnCountEqualTo() {
        assertThat(KindAsserter.onCountEqualTo(2).apply(getData(1, 2))).isTrue();
        assertThat(KindAsserter.onCountEqualTo(2).apply(getData(1, 1))).isFalse();
    }

    @Test
    public void testExtractRoll() {
        assertThat(KindAsserter.extractPoints().convert(getData(1, 5))).isEqualTo(5);
    }

    @Test
    public void should_have_no_pair() {
        Roll anyRoll = new Roll(1, 2, 3, 4, 5);

        Integer points = new KindAsserter(2).givePoints(anyRoll);

        assertThat(points).isEqualTo(0);
    }

    @Test
    public void should_have_one_pair_of_one() {
        Roll pairOfOne = new Roll(1, 1, 3, 4, 5);

        Integer points = new KindAsserter(2).givePoints(pairOfOne);

        assertThat(points).isEqualTo(2);
    }

    @Test
    public void should_have_one_pair_of_five() {
        Roll pairOfOne = new Roll(1, 1, 3, 5, 5);

        Integer points = new KindAsserter(2).givePoints(pairOfOne);

        assertThat(points).isEqualTo(10);
    }

    private Multiset.Entry<Integer> getData(Integer element, int count) {
        return immutableEntry(element, count);
    }
}
