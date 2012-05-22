package org.xbucchiotty.yahtzee;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 19:16
 */
public class ScoreTest {

    @Test
    public void should_score_yahtzee() {
        Roll giveRoll_yahtzee = new Roll(1, 1, 1, 1, 1);
        Score score = new Score();

        score.scoreYahtzee(giveRoll_yahtzee);

        assertThat(score.getTotalScore()).isEqualTo(50);
    }

    @Test
    public void should_not_score_second_yahtzee() {
        Roll giveRoll_anything = new Roll(1, 2, 1, 1, 1);
        Roll giveRoll_yahtzee = new Roll(1, 1, 1, 1, 1);
        Score score = new Score();

        score.scoreYahtzee(giveRoll_anything);
        score.scoreYahtzee(giveRoll_yahtzee);

        assertThat(score.getTotalScore()).isEqualTo(0);
    }

    @Test
    public void should_score_change() {
        Roll givenAnyRoll = new Roll(1, 3, 2, 5, 6);
        Score score = new Score();

        score.scoreChance(givenAnyRoll);

        assertThat(score.getTotalScore()).isEqualTo(1 + 3 + 2 + 5 + 6);
    }

}
