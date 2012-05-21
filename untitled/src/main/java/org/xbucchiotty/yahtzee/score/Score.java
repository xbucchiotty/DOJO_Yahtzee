package org.xbucchiotty.yahtzee.score;

import org.xbucchiotty.yahtzee.category.Category;

import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkArgument;

/**
* User: xbucchiotty
* Date: 21/05/12
* Time: 09:15
*/
public class Score {
    private final Integer[] scores;

    public Score(@NotNull Integer i, @NotNull Integer i1, @NotNull Integer i2, @NotNull Integer i3, @NotNull Integer i4) {
        checkArgument(i != null);
        checkArgument(i1 != null);
        checkArgument(i2 != null);
        checkArgument(i3 != null);
        checkArgument(i4 != null);

        scores = new Integer[]{i, i1, i2, i3, i4};
    }

    public Integer registerInCategory(@NotNull Category category) {
        checkArgument(category != null);
        return category.register(this);
    }

    public Integer[] getScores() {
        return scores;
    }
}
