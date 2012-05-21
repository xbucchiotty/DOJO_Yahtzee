package org.xbucchiotty.yahtzee;

import com.google.common.base.Predicate;

import javax.annotation.Nullable;

/**
 * User: xbucchiotty
 * Date: 21/05/12
 * Time: 18:47
 */
public abstract class Functions {

    public static <T> Predicate<T> sameElement() {
        return new Predicate<T>() {
            private T firstElement;

            @Override
            public boolean apply(@Nullable T element) {
                if (firstElement == null) {
                    firstElement = element;

                }
                return firstElement != null && firstElement.equals(element);
            }

        };
    }
}
