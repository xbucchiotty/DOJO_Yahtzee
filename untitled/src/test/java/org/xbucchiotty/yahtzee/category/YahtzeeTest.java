package org.xbucchiotty.yahtzee.category;

import com.google.common.base.Predicate;
import org.junit.Test;
import org.xbucchiotty.yahtzee.score.Score;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 08:57
 */
public class YahtzeeTest {

    @Test
    public void should_score_50() {
        Score givenScore_yahtzee = new Score(1, 1, 1, 1, 1);
        assertThat(givenScore_yahtzee.registerInCategory(Categories.yahtzee())).isEqualTo(50);
    }

    @Test
    public void should_score_0() {
        Score givenScore_yahtzee = new Score(2, 1, 1, 1, 1);
        assertThat(givenScore_yahtzee.registerInCategory(Categories.yahtzee())).isEqualTo(0);
    }

    @Test
    public void should_satisfy_yahtzee() {
        Score givenScore_yahtzee = new Score(1, 1, 1, 1, 1);
        assertThat(new Yahtzee().isRuleStatisfied(givenScore_yahtzee)).isTrue();
    }

    @Test
    public void should_not_satisfy_yahtzee() {
        Score givenScore_yahtzee = new Score(2, 1, 1, 1, 1);
        assertThat(new Yahtzee().isRuleStatisfied(givenScore_yahtzee)).isFalse();
    }

    @Test
    public void testSameScore() {
        Predicate<Integer> sameScoreAsserter = Yahtzee.sameScore();
        assertThat(sameScoreAsserter.apply(1)).isTrue();
        assertThat(sameScoreAsserter.apply(1)).isTrue();
        assertThat(sameScoreAsserter.apply(2)).isFalse();
    }
}
