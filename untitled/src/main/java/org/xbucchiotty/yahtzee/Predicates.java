package org.xbucchiotty.yahtzee;

import com.google.common.base.Predicate;
import com.google.common.collect.Multiset;

import static com.google.common.base.Predicates.equalTo;

/**
 * User: xbucchiotty
 * Date: 23/05/12
 * Time: 19:05
 */
public class Predicates {

    public static Predicate<Multiset.Entry<Integer>> onCountEqualTo(final int reference) {
        return new Predicate<Multiset.Entry<Integer>>() {
            @Override
            public boolean apply(Multiset.Entry<Integer> collectionEntry) {
                return equalTo(reference).apply(collectionEntry.getCount());
            }
        };
    }
}
