package org.xbucchiotty.yahtzee;

import org.junit.Test;
import org.xbucchiotty.yahtzee.categoryasserter.CategoryAsserter;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

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

    @Test
    public void should_score_pairOf5() {
        Roll givenRollWithPairOfFive = new Roll(1, 1, 5, 5, 6);
        Score scoreTen = new Score();

        scoreTen.scorePair(givenRollWithPairOfFive);

        assertThat(scoreTen.getTotalScore()).isEqualTo(10);
    }

    @Test
    public void should_score_threeOfKind6() {
        Roll givenRollWithThreeSix = new Roll(1, 2, 6, 6, 6);
        Score scoreEighteen = new Score();

        scoreEighteen.scoreThreeOfKind(givenRollWithThreeSix);

        assertThat(scoreEighteen.getTotalScore()).isEqualTo(18);
    }

    @Test
    public void should_score_fourOfFour() {
        Roll givenRollWithFourFour = new Roll(4, 4, 4, 6, 4);
        Score scoreSixteen = new Score();

        scoreSixteen.scoreFourOfKind(givenRollWithFourFour);

        assertThat(scoreSixteen.getTotalScore()).isEqualTo(16);
    }

    @Test
    public void should_not_score_fourOfKind() {
        Roll anyRoll = new Roll(3, 4, 4, 6, 4);
        Score scoreZero = new Score();

        scoreZero.scoreFourOfKind(anyRoll);

        assertThat(scoreZero.getTotalScore()).isEqualTo(0);
    }

    @Test
    public void should_score_two_pairs_of_two_and_five() {
        Roll givenRollWithPairOfTwoAndFive = new Roll(2, 2, 5, 1, 5);
        Score scoreFourteen = new Score();

        scoreFourteen.scoreTwoPairs(givenRollWithPairOfTwoAndFive);

        assertThat(scoreFourteen.getTotalScore()).isEqualTo(14);
    }

    @Test
    public void should_score_full_house() {
        Roll givenRollWithFullHouse = new Roll(1, 1, 2, 2, 2);
        Score scoreEight = new Score();

        scoreEight.scoreFullHouse(givenRollWithFullHouse);

        assertThat(scoreEight.getTotalScore()).isEqualTo(8);
    }

    @Test
    public void should_score_small_straight() {
        Roll givenRollWithSmallStraight = new Roll(1, 2, 3, 4, 5);

        Score scoreFifteen = new Score();
        scoreFifteen.scoreSmallStraight(givenRollWithSmallStraight);

        assertThat(scoreFifteen.getTotalScore()).isEqualTo(15);
    }

    @Test
    public void should_score_large_straight() {
        Roll givenRollWithSmallStraight = new Roll(2, 3, 4, 5, 6);

        Score scoreFifteen = new Score();
        scoreFifteen.scoreLargeStraight(givenRollWithSmallStraight);

        assertThat(scoreFifteen.getTotalScore()).isEqualTo(20);
    }

    @Test
    public void testRegisterScore() {
        Category mock = spy(new Category(mock(CategoryAsserter.class)));
        Roll roll = new Roll(1, 1, 1, 1, 1);
        Score score = new Score();
        score.registerScore(roll, mock);

        assertThat(score.categoriesScored).hasSize(1);
        verify(mock, times(1)).registerRoll(roll);
    }
}
