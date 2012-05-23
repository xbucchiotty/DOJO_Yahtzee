package org.xbucchiotty.yahtzee.categoryasserter;

import org.xbucchiotty.yahtzee.Roll;

import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.sum;
import static org.xbucchiotty.yahtzee.Points.ZERO;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 19:26
 */
public class ChanceAsserter implements CategoryAsserter {

    @Override
    public Integer givePoints(Roll roll) {
        return reduce(sum(), roll.getRolls()).or(ZERO);
    }
}
