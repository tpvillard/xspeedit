package com.biffbangpow.xspeedit.strategy;


import java.util.List;

/**
 * A first fit search.
 *
 * <p>The first box in which the item will fit is selected.</p>
 *
 */
public class FirstFitSearch implements SearchBoxStrategy {

    @Override
    public Box searchBox(int item, List<Box> boxes) {

        return boxes.stream().filter(box -> box.fitFor(item)).findFirst().orElse(null);
    }
}
