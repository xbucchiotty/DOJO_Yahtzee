package org.xbucchiotty.yahtzee;

import com.google.common.base.Predicate;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 18:50
 */
public class FunctionsTest {
    @Test
    public void testSameElement() throws Exception {
        Predicate<Integer> sameElement = Functions.sameElement();
        assertThat(sameElement.apply(1)).isTrue();
        assertThat(sameElement.apply(1)).isTrue();
        assertThat(sameElement.apply(2)).isFalse();
    }
}
