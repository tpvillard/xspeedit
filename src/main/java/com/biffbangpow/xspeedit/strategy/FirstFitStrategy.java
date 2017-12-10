package com.biffbangpow.xspeedit.strategy;


import com.biffbangpow.xspeedit.strategy.AbstractFitStrategy;

import java.util.List;

/**
 * A robot implementing first fit algorithm.
 *
 * <p>Search for a box in the opened box list in which the item will fit. The first box found is used.</p>
 *
 */
public class FirstFitStrategy extends AbstractFitStrategy {

    /**
     * Returns a box in which the item can fit. The first box found is used.
     * @param item the item to pack
     * @param boxes the list of opened boxes
     * @return the box or null if no box is found
     */
    @Override
    protected Box searchBox(int item, List<Box> boxes) {

        Box found = null;
        for (Box box : boxes) {
            if (box.fitFor(item)) {
                found = box;
                break;
            }
        }
        return found;
    }
}
