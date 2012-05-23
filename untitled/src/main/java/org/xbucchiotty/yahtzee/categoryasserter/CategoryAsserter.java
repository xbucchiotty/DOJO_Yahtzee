package org.xbucchiotty.yahtzee.categoryasserter;

import org.xbucchiotty.yahtzee.Roll;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 09:13
 */
public interface CategoryAsserter {

    int PAIR = 2;
    int TWO = 2;
    int THREE_OF_KIND = 3;
    int FOUR_OF_KIND = 4;

    Integer givePoints(Roll roll);
}
