package org.xbucchiotty.yahtzee.categoryasserter;


import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 19:11
 */
public class TwoPairsAsserterTest {

    @Test
    public void should_have_two_pairs() throws Exception {
        Roll rollWithTwoPairs = new Roll(1, 1, 2, 5, 2);

        assertThat(new TwoPairsAsserter().givePoints(rollWithTwoPairs)).isEqualTo(6);
    }

    @Test
    public void should_not_have_two_pairs() throws Exception {
        Roll anyRoll = new Roll(1, 1, 1, 5, 2);

        assertThat(new TwoPairsAsserter().givePoints(anyRoll)).isEqualTo(0);
    }
}
