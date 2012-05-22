package org.xbucchiotty.yahtzee.category;

import org.xbucchiotty.yahtzee.Points;
import org.xbucchiotty.yahtzee.Roll;
import org.xbucchiotty.yahtzee.categoryasserter.CategoryAsserter;

import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 19:10
 */
public class Category {

    private final CategoryAsserter asserter;
    private final Points points;

    public Category(@NotNull CategoryAsserter asserter) {
        checkArgument(asserter != null);

        this.asserter = asserter;
        this.points = new Points();
    }

    public void registerRoll(Roll roll) {
        points.setPoints(asserter.givePoints(roll));
    }

    public Integer getPoints() {
        return points.getPoints();
    }
}
