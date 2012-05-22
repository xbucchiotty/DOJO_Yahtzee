package org.xbucchiotty.yahtzee;

import javax.validation.constraints.NotNull;

public class Points {
    public static final int ZERO = 0;

    private Integer points;
    private boolean set;

    public Points() {
        points = 0;
        set = false;
    }

    public void setPoints(@NotNull Integer points) {
        if (!set) {
            this.points = points;
            set = true;
        }
    }

    public Integer getPoints() {
        return points;
    }
}