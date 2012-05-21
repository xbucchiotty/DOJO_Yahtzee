package org.xbucchiotty.yahtzee.category;

import org.xbucchiotty.yahtzee.score.Score;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 09:13
 */
public interface Category {

    Integer register(Score score);
}
