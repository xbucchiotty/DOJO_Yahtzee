package org.xbucchiotty.yahtzee;

import com.google.common.base.Predicate;
import org.junit.Test;
import org.xbucchiotty.utils.function.Reducer;

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
        Reducer<Integer, Integer> sumOperator = Functions.sum();
        sumOperator.agrege(1);
        sumOperator.agrege(2);
        sumOperator.agrege(3);
        assertThat(sumOperator.getResult()).isEqualTo(6);
    }
}
