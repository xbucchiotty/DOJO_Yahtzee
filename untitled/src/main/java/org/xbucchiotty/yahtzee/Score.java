package org.xbucchiotty.yahtzee;

import org.xbucchiotty.utils.function.Converter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Sets.newHashSet;
import static org.xbucchiotty.utils.function.FunctionHelper.map;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.sum;
import static org.xbucchiotty.yahtzee.Points.ZERO;
import static org.xbucchiotty.yahtzee.categoryasserter.CategoryAsserters.*;
import static org.xbucchiotty.yahtzee.categoryasserter.SerieAsserter.Serie;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 18:56
 */
public class Score {

    private final Category yahtzee = new Category(yahtzee());
    private final Category chance = new Category(chance());
    private final Map<Serie, Category> series;
    final Collection<Category> categoriesScored = newHashSet();
    private final Category pair = new Category(pair());
    private final Category threeOfKind = new Category(threeOfKind());
    private final Category fourOfKind = new Category(fourOfKind());
    private final Category twoPairs = new Category(twoPairs());
    private final Category fullHouse = new Category(fullHouse());
    private final Category smallStraight = new Category(smallStraight());
    private final Category largeStraight = new Category(largeStraight());

    public Score() {
        series = new HashMap<Serie, Category>();

        for (Serie serie : Serie.values()) {
            series.put(serie, new Category(serie(serie)));
        }
    }

    public void scoreYahtzee(Roll roll) {
        registerScore(roll, yahtzee);
    }

    public void scoreChance(Roll roll) {
        registerScore(roll, chance);
    }

    public void scoreSerieOne(Roll roll) {
        registerScore(roll, Serie.ONE);
    }

    public void scoreSerieTwo(Roll roll) {
        registerScore(roll, Serie.TWO);
    }

    public void scoreSerieThree(Roll roll) {
        registerScore(roll, Serie.THREE);
    }

    public void scoreSerieFour(Roll roll) {
        registerScore(roll, Serie.FOUR);
    }

    public void scoreSerieFive(Roll roll) {
        registerScore(roll, Serie.FIVE);
    }

    public void scoreSerieSix(Roll roll) {
        registerScore(roll, Serie.SIX);
    }

    public void scorePair(Roll roll) {
        registerScore(roll, pair);
    }

    public void scoreThreeOfKind(Roll roll) {
        registerScore(roll, threeOfKind);
    }

    public void scoreFourOfKind(Roll roll) {
        registerScore(roll, fourOfKind);
    }

    public void scoreTwoPairs(Roll roll) {
        registerScore(roll, twoPairs);
    }

    public void scoreFullHouse(Roll roll) {
        registerScore(roll, fullHouse);
    }

    public void scoreSmallStraight(Roll roll) {
        registerScore(roll, smallStraight);
    }

    public void scoreLargeStraight(Roll roll) {
        registerScore(roll, largeStraight);
    }

    void registerScore(Roll roll, Category category) {
        category.registerRoll(roll);
        categoriesScored.add(category);
    }

    private void registerScore(Roll roll, Serie serie) {
        Category category = series.get(serie);
        category.registerRoll(roll);
        categoriesScored.add(category);
    }

    public Integer getTotalScore() {
        return
                reduce(
                        sum(),
                        map(
                                getPoints(),
                                categoriesScored
                        )
                ).or(ZERO);
    }

    private Converter<Category, Integer> getPoints() {
        return new Converter<Category, Integer>() {
            @Override
            public Integer convert(Category points) {
                return points.getPoints();
            }
        };
    }
}
