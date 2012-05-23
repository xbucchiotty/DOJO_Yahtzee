package org.xbucchiotty.yahtzee;

import javax.validation.constraints.NotNull;
import java.util.Collection;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 09:15
 */
public class Roll {

    public static final int SIZE = 5;

    private final Collection<Integer> rolls;

    public Roll(@NotNull Integer i, @NotNull Integer i1, @NotNull Integer i2, @NotNull Integer i3, @NotNull Integer i4) {
        checkArgument(i != null);
        checkArgument(i1 != null);
        checkArgument(i2 != null);
        checkArgument(i3 != null);
        checkArgument(i4 != null);

        rolls = unmodifiableList(asList(i, i1, i2, i3, i4));
    }

    public Collection<Integer> getRolls() {
        return rolls;
    }
}
