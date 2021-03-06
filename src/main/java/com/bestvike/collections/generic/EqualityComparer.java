package com.bestvike.collections.generic;

import java.util.Objects;

/**
 * Created by 许崇雷 on 2017-07-18.
 */
public final class EqualityComparer<T> implements IEqualityComparer<T> {
    private static final EqualityComparer DEFAULT = new EqualityComparer();

    private EqualityComparer() {
    }

    public static <T> EqualityComparer<T> Default() {
        //noinspection unchecked
        return DEFAULT;
    }

    @Override
    public boolean equals(Object x, Object y) {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(T obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    public int indexOf(Object[] array, Object value, int startIndex, int count) {
        int endIndex = startIndex + count;
        for (int i = startIndex; i < endIndex; i++) {
            if (this.equals(array[i], value))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T[] array, T value, int startIndex, int count) {
        int endIndex = startIndex - count + 1;
        for (int i = startIndex; i >= endIndex; i--) {
            if (this.equals(array[i], value))
                return i;
        }
        return -1;
    }
}
