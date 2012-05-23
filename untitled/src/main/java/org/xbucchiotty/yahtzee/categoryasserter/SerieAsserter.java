package org.xbucchiotty.yahtzee.categoryasserter;

import org.xbucchiotty.yahtzee.Roll;

import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Predicates.equalTo;
import static com.google.common.collect.Iterables.filter;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.sum;
import static org.xbucchiotty.yahtzee.Points.ZERO;

/**
 * User: xbucchiotty
 * Date: 22/05/12
 * Time: 12:44
 */
public class SerieAsserter implements CategoryAsserter {

    private final Serie serie;

    public SerieAsserter(@NotNull Serie serie) {
        checkArgument(serie != null);
        this.serie = serie;
    }

    @Override
    public Integer givePoints(Roll roll) {
        return reduce(
                sum(),
                filter(
                        roll.getRolls(),
                        equalTo(serie.getIndex()
                        )
                )
        ).or(ZERO);
    }


    public static enum Serie {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

        private int index;

        private Serie(int index) {
            this.index = index;
        }

        private int getIndex() {
            return index;
        }
    }
}
