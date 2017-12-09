package com.biffbangpow.xspeedit;


import java.util.List;

/**
 * A robot implementing best fit algorithm.
 *
 * <p>Search for a box in the opened box list in which the item will fit.
 * The box having the minimum space left is selected.</p>
 *
 */
public class BestFitRobot extends AbstractBestFirstFitRobot {

    /**
     * Returns the first box in which the item can fit.
     * @param item the item to pack
     * @param boxes the list of opened boxes
     * @return the box or null if no box is found
     */
    @Override
    protected Box searchBox(int item, List<Box> boxes) {

        Box found = null;
        int minSpaceLeft = 10;
        for (Box box : boxes) {
            if (box.fitFor(item)) {
                int spaceLeft = box.getSpaceLeft() - item;
                if (spaceLeft <= minSpaceLeft) {
                    minSpaceLeft = spaceLeft;
                    found = box;
                }
            }
        }
        return found;
    }
}
