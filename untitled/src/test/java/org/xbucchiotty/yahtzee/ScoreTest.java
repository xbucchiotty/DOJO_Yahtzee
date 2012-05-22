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

    @Test
    public void should_score_1serie() {
        Roll givenRollWithTwo1 = new Roll(1, 1, 2, 5, 6);
        Roll givenRollWithZero1 = new Roll(2, 2, 2, 5, 6);
        Score scoreTwo = new Score();
        Score scoreZero = new Score();

        scoreTwo.scoreSerieOne(givenRollWithTwo1);
        scoreZero.scoreSerieOne(givenRollWithZero1);

        assertThat(scoreTwo.getTotalScore()).isEqualTo(2);
        assertThat(scoreZero.getTotalScore()).isEqualTo(0);
    }

    @Test
    public void should_score_2serie() {
        Roll givenRollWithZero2 = new Roll(1, 1, 3, 5, 6);
        Roll givenRollWithThree2 = new Roll(2, 2, 2, 5, 6);
        Score scoreZero = new Score();
        Score scoreSix = new Score();

        scoreZero.scoreSerieTwo(givenRollWithZero2);
        scoreSix.scoreSerieTwo(givenRollWithThree2);

        assertThat(scoreZero.getTotalScore()).isEqualTo(0);
        assertThat(scoreSix.getTotalScore()).isEqualTo(6);
    }

    @Test
    public void should_score_3serie() {
        Roll givenRollWithZero3 = new Roll(1, 1, 4, 5, 6);
        Roll givenRollWithTwo3 = new Roll(2, 3, 3, 5, 6);
        Score scoreZero = new Score();
        Score scoreSix = new Score();

        scoreZero.scoreSerieThree(givenRollWithZero3);
        scoreSix.scoreSerieThree(givenRollWithTwo3);

        assertThat(scoreZero.getTotalScore()).isEqualTo(0);
        assertThat(scoreSix.getTotalScore()).isEqualTo(6);
    }

    @Test
    public void should_score_4serie() {
        Roll givenRollWithZero4 = new Roll(1, 1, 5, 5, 6);
        Roll givenRollWithFive4 = new Roll(4, 4, 4, 4, 4);
        Score scoreZero = new Score();
        Score scoreTwenty = new Score();

        scoreZero.scoreSerieFour(givenRollWithZero4);
        scoreTwenty.scoreSerieFour(givenRollWithFive4);

        assertThat(scoreZero.getTotalScore()).isEqualTo(0);
        assertThat(scoreTwenty.getTotalScore()).isEqualTo(20);
    }

    @Test
    public void should_score_5serie() {
        Roll givenRollWithTwo5 = new Roll(1, 1, 5, 5, 6);
        Roll givenRollWithOne5 = new Roll(5, 4, 4, 4, 4);
        Score scoreTen = new Score();
        Score scoreFive = new Score();

        scoreTen.scoreSerieFive(givenRollWithTwo5);
        scoreFive.scoreSerieFive(givenRollWithOne5);

        assertThat(scoreTen.getTotalScore()).isEqualTo(10);
        assertThat(scoreFive.getTotalScore()).isEqualTo(5);
    }

    @Test
    public void should_score_6serie() {
        Roll givenRollWithOneSix = new Roll(1, 1, 5, 5, 6);
        Roll givenRollWithFive4 = new Roll(4, 6, 4, 6, 6);
        Score scoreSix = new Score();
        Score scoreEighteen = new Score();

        scoreSix.scoreSerieSix(givenRollWithOneSix);
        scoreEighteen.scoreSerieSix(givenRollWithFive4);

        assertThat(scoreSix.getTotalScore()).isEqualTo(6);
        assertThat(scoreEighteen.getTotalScore()).isEqualTo(18);
    }

}
