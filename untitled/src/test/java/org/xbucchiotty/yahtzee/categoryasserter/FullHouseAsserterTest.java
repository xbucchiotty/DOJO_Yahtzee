package org.xbucchiotty.yahtzee.categoryasserter;

import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 19:29
 */
public class FullHouseAsserterTest {

    @Test
    public void should_have_full_house() {
        Roll rollWithFullHouse = new Roll(1, 2, 2, 1, 1);

        assertThat(new FullHouseAsserter().givePoints(rollWithFullHouse)).isEqualTo(7);
    }

    @Test
    public void should_not_have_full_house() {
        Roll anyRoll = new Roll(1, 2, 3, 1, 1);

        assertThat(new FullHouseAsserter().givePoints(anyRoll)).isEqualTo(0);
    }
}
