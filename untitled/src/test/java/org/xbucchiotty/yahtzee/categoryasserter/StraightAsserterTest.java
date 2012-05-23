package org.xbucchiotty.yahtzee.categoryasserter;

import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static org.fest.assertions.Assertions.assertThat;
import static org.xbucchiotty.yahtzee.categoryasserter.StraightAsserter.SMALL_STRAIGHT;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 22:08
 */
public class StraightAsserterTest {

    @Test
    public void should_have_small_straight() {
        assertThat(new StraightAsserter(SMALL_STRAIGHT).givePoints(new Roll(1, 2, 3, 4, 5))).isEqualTo(15);
    }

    @Test
    public void should_not_have_small_straight() {
        assertThat(new StraightAsserter(SMALL_STRAIGHT).givePoints(new Roll(1, 1, 4, 4, 5))).isEqualTo(0);
        assertThat(new StraightAsserter(SMALL_STRAIGHT).givePoints(new Roll(2, 3, 4, 5, 6))).isEqualTo(0);
    }
}
