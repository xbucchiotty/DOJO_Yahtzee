package org.xbucchiotty.yahtzee.categoryasserter;

import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 08:01
 */
public class KindAsserterTest {

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

}
