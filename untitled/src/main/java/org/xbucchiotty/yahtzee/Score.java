package org.xbucchiotty.yahtzee;

import org.xbucchiotty.utils.function.Converter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.collect.Sets.newHashSet;
import static org.xbucchiotty.utils.function.FunctionHelper.map;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.sum;
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
    private final Collection<Category> categoriesScored = newHashSet();

    public Score() {
        series = new HashMap<Serie, Category>();

        for (Serie serie : Serie.values()) {
            series.put(serie, new Category(serie(serie)));
        }
    }

    public void scoreYahtzee(Roll roll) {
        yahtzee.registerRoll(roll);
        categoriesScored.add(yahtzee);
    }

    public void scoreChance(Roll roll) {
        chance.registerRoll(roll);
        categoriesScored.add(chance);
    }

    public void scoreSerieOne(Roll roll) {
        scoreSerie(roll, Serie.ONE);
    }

    public void scoreSerieTwo(Roll roll) {
        scoreSerie(roll, Serie.TWO);
    }

    public void scoreSerieThree(Roll roll) {
        scoreSerie(roll, Serie.THREE);
    }

    public void scoreSerieFour(Roll roll) {
        scoreSerie(roll, Serie.FOUR);
    }

    public void scoreSerieFive(Roll roll) {
        scoreSerie(roll, Serie.FIVE);
    }

    public void scoreSerieSix(Roll roll) {
        scoreSerie(roll, Serie.SIX);
    }

    private void scoreSerie(Roll roll, Serie serie) {
        Category category = series.get(serie);
        category.registerRoll(roll);
        categoriesScored.add(category);
    }

    public Integer getTotalScore() {
        return reduce(
                sum(),
                map(
                        getPoints(),
                        categoriesScored));
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
