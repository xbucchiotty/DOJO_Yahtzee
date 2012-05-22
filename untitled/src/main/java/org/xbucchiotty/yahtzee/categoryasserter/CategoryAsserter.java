package org.xbucchiotty.yahtzee.categoryasserter;

import org.xbucchiotty.yahtzee.Roll;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 09:13
 */
public interface CategoryAsserter {

    Integer givePoints(Roll roll);
}
