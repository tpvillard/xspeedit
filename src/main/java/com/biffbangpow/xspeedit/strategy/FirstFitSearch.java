package com.biffbangpow.xspeedit.strategy;


import java.util.List;

/**
 * A first fit search.
 *
 * <p>Search for a box in the opened box list in which the item will fit. The first box found is used.</p>
 *
 */
public class FirstFitSearch implements SearchBoxStrategy {

    @Override
    public Box searchBox(int item, List<Box> boxes) {

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
