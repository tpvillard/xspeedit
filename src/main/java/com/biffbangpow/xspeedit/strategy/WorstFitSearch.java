package com.biffbangpow.xspeedit.strategy;


import java.util.Comparator;
import java.util.List;

/**
 * A worst fit search.
 *
 * <p>The box having the maximum space left is selected.</p>
 */
public class WorstFitSearch implements SearchBoxStrategy {

    @Override
    public Box searchBox(int item, List<Box> boxes) {

        return boxes.stream().filter(box -> box.fitFor(item)).max(Box.COMPARATOR).orElse(null);
    }
}
