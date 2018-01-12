package com.biffbangpow.xspeedit.strategy;


import java.util.Comparator;
import java.util.List;

/**
 * A best fit search.
 * <p>The box having the minimum space left is selected.</p>
 */
public class BestFitSearch implements SearchBoxStrategy {

    @Override
    public Box searchBox(int item, List<Box> boxes) {

        return boxes.stream().filter(box -> box.fitFor(item)).min(Box.COMPARATOR).orElse(null);
    }
}
