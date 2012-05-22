package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.base.Predicate;
import org.junit.Test;
import org.xbucchiotty.yahtzee.Roll;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 08:57
 */
public class YahtzeeAsserterTest {

    @Test
    public void should_satisfy_yahtzee() {
        Roll givenRoll_yahtzee = new Roll(1, 1, 1, 1, 1);
        assertThat(new YahtzeeAsserter().isRuleStatisfied(givenRoll_yahtzee)).isTrue();
    }

    @Test
    public void should_not_satisfy_yahtzee() {
        Roll givenRoll_yahtzee = new Roll(2, 1, 1, 1, 1);
        assertThat(new YahtzeeAsserter().isRuleStatisfied(givenRoll_yahtzee)).isFalse();
    }

    @Test
    public void testSameScore() {
        Predicate<Integer> sameScoreAsserter = YahtzeeAsserter.sameScore();
        assertThat(sameScoreAsserter.apply(1)).isTrue();
        assertThat(sameScoreAsserter.apply(1)).isTrue();
        assertThat(sameScoreAsserter.apply(2)).isFalse();
    }
}
