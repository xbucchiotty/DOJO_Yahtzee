package org.xbucchiotty.yahtzee.categoryasserter;

import com.google.common.collect.Multiset;
import org.xbucchiotty.yahtzee.Functions;
import org.xbucchiotty.yahtzee.Roll;

import java.util.Set;

import static org.xbucchiotty.utils.function.FunctionHelper.map;
import static org.xbucchiotty.utils.function.FunctionHelper.reduce;
import static org.xbucchiotty.yahtzee.Functions.extractPoints;
import static org.xbucchiotty.yahtzee.Functions.sum;
import static org.xbucchiotty.yahtzee.Points.ZERO;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 19:34
 */
public class SmallStraightAsserter implements CategoryAsserter {

    private static final int SCORE = 15;

    @Override
    public Integer givePoints(Roll roll) {
        Set<Multiset.Entry<Integer>> rollsByValue = Functions.groupRollByValue().convert(roll);

        final int result;
        if (rollsByValue.size() == Roll.SIZE) {
            //If there is as distinct roll value as the roll size, this means that 
            //each roll value is different
            //if the sum is correct, we have the requested sum
            if (reduce(sum(), map(extractPoints(), rollsByValue)).get() == SCORE) {
                result = SCORE;
            } else {
                result = ZERO;
            }
        } else {
            result = ZERO;
        }
        return result;
    }
}
