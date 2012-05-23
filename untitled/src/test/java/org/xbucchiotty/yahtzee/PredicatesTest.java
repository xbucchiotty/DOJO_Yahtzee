package org.xbucchiotty.yahtzee;

import com.google.common.collect.Multiset;
import org.junit.Test;

import static com.google.common.collect.Multisets.immutableEntry;
import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 19:05
 */
public class PredicatesTest {


    @Test
    public void testOnCountEqualTo() {
        assertThat(Predicates.onCountEqualTo(2).apply(getData(1, 2))).isTrue();
        assertThat(Predicates.onCountEqualTo(2).apply(getData(1, 1))).isFalse();
    }

    private Multiset.Entry<Integer> getData(Integer element, int count) {
        return immutableEntry(element, count);
    }
}
