package com.bestvike.linq.entity;

import java.util.Iterator;

/**
 * @author 许崇雷
 * @date 2017/7/28
 */
public final class IterableDemo implements Iterable<String> {
    private final int count;

    public IterableDemo(int count) {
        this.count = count;
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorDemo(this.count);
    }
}
