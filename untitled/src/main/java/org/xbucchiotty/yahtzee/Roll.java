package org.xbucchiotty.yahtzee;

import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 09:15
 */
public class Roll {
    private final Integer[] rolls;

    public Roll(@NotNull Integer i, @NotNull Integer i1, @NotNull Integer i2, @NotNull Integer i3, @NotNull Integer i4) {
        checkArgument(i != null);
        checkArgument(i1 != null);
        checkArgument(i2 != null);
        checkArgument(i3 != null);
        checkArgument(i4 != null);

        rolls = new Integer[]{i, i1, i2, i3, i4};
    }

    public Integer[] getRolls() {
        return rolls;
    }
}
