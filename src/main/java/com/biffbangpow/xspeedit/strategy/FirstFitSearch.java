package com.biffbangpow.xspeedit.strategy;


import java.util.List;
import java.util.Optional;

/**
 * A first fit search.
 *
 * <p>Search for a box in the opened box list in which the item will fit. The first box found is used.</p>
 *
 */
public class FirstFitSearch implements SearchBoxStrategy {

    @Override
    public Box searchBox(int item, List<Box> boxes) {

        return boxes.stream().filter(box -> box.fitFor(item)).findFirst().orElse(null);
    }
}
