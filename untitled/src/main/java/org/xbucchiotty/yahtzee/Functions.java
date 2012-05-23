package org.xbucchiotty.yahtzee;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.xbucchiotty.utils.function.Reducer;

import javax.annotation.Nullable;

import static com.google.common.base.Optional.fromNullable;

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

    public static Reducer<Integer, Optional<Integer>> sum() {
        return new Reducer<Integer, Optional<Integer>>() {
            private Integer sum = 0;

            @Override
            public void agrege(Integer integer) {
                if (integer != null) {

                    sum += integer;
                }
            }

            @Override
            public Optional<Integer> getResult() {
                return fromNullable(sum);
            }
        };
    }

    public static <E extends Comparable<E>> Reducer<E, Optional<E>> getHighest() {
        return new Reducer<E, Optional<E>>() {
            E highestElement = null;

            @Override
            public void agrege(E e) {
                if (highestElement == null) {
                    highestElement = e;
                } else {
                    if (e.compareTo(highestElement) > 0) {
                        highestElement = e;
                    }
                }
            }

            @Override
            public Optional<E> getResult() {
                return Optional.fromNullable(highestElement);
            }
        };
    }

}
