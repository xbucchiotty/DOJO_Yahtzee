package org.xbucchiotty.yahtzee;

import org.xbucchiotty.utils.function.Converter;
import org.xbucchiotty.yahtzee.category.Category;

import static org.xbucchiotty.utils.function.FunctionHelper.map;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.sum;
import static org.xbucchiotty.yahtzee.categoryasserter.CategoryAsserters.chance;
import static org.xbucchiotty.yahtzee.categoryasserter.CategoryAsserters.yahtzee;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 18:56
 */
public class Score {

    private Category yahtzee = new Category(yahtzee());
    private Category chance = new Category(chance());

    public void scoreYahtzee(Roll roll) {
        yahtzee.registerRoll(roll);
    }

    public void scoreChance(Roll roll) {
        chance.registerRoll(roll);
    }

    public Integer getTotalScore() {
        return reduce(
                sum(),
                map(
                        getPoints(),
                        yahtzee,
                        chance));
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
