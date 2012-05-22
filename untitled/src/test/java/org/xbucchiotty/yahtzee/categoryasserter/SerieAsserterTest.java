package org.xbucchiotty.yahtzee.categoryasserter;

import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 22/05/12
 * Time: 16:48
 */
public class SerieAsserterTest {

    @Test
    public void testSerie1_should_have_zero() {
        Roll givenRoll_without1 = new Roll(2, 2, 2, 2, 2);

        SerieAsserter serieAsserter = new SerieAsserter(SerieAsserter.Serie.ONE);

        assertThat(serieAsserter.givePoints(givenRoll_without1)).isEqualTo(0);
    }

    @Test
    public void testSerie1_should_have_4() {
        Roll givenRoll_withFour1 = new Roll(2, 1, 1, 1, 1);

        SerieAsserter serieAsserter = new SerieAsserter(SerieAsserter.Serie.ONE);

        assertThat(serieAsserter.givePoints(givenRoll_withFour1)).isEqualTo(4);
    }
}
