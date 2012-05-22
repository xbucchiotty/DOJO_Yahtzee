package org.xbucchiotty.yahtzee.categoryasserter;

import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 22/05/12
 * Time: 08:13
 */
public class ChanceAsserterTest {

    @Test
    public void should_give_5_points() {
        assertThat(new ChanceAsserter().givePoints(new Roll(1, 1, 1, 1, 1))).isEqualTo(5);
    }
}
