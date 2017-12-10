package com.biffbangpow.xspeedit.strategy;

/**
 * A default packing strategy.
 *
 * <p>the default packing strategy uses the most basic algorithm.
 * It places each item into the current box as long as it will fit in.</p>
 * <p>If it does not fit, the current box is closed and a new one is created</p>
 *
 */
public class DefaultPackingStrategy extends AbstractPackingStrategy {


    @Override
    public String doPack(int[] items) {

        // only one box is used at any given time.
        stat.incOpenedBoxCount();
        StringBuilder boxes = new StringBuilder();
        int sum = 0;
        for (int item: items) {
            sum = sum + item;
            if (sum > BOX_CAPACITY) {

                // Close the box, create a new one
                sum = item;
                boxes.append("/").append(item);
                stat.incBoxCount();
            } else {
                boxes.append(item);
            }
        }
        return boxes.toString();
    }
}
