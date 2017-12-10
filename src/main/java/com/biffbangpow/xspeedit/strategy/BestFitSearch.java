package com.biffbangpow.xspeedit.strategy;


import java.util.List;

/**
 * A best fit search.
 * <p>The box having the minimum space left is selected.</p>
 */
public class BestFitSearch implements SearchBoxStrategy {

    @Override
    public Box searchBox(int item, List<Box> boxes) {

        Box found = null;
        int minSpaceLeft = 10;
        for (Box box : boxes) {
            if (box.fitFor(item)) {
                int spaceLeft = box.getSpaceLeft() - item;
                if (spaceLeft == 0) {
                    found = box;
                    break;
                } else if (spaceLeft <= minSpaceLeft) {
                    minSpaceLeft = spaceLeft;
                    found = box;
                }
            }
        }
        return found;
    }
}
