package com.biffbangpow.xspeedit.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * A box containing items.
 */
public class Box {

    public static final int CAPACITY = 10;

    private final List<Integer> items = new ArrayList<>();
    private int sum = 0;

    public void add(int item) {
        items.add(item);
        sum = sum + item;
    }

    public boolean fitFor(int item) {
        return sum + item <= CAPACITY;
    }

    public boolean isFull() {
        return sum == CAPACITY;
    }

    protected int getSpaceLeft() {
        return CAPACITY - sum;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer item : items) {
            builder.append(item);
        }
        return builder.toString();
    }
}
