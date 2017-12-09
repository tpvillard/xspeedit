package com.biffbangpow.xspeedit;

/**
 * A default robot implementation.
 *
 * <p>the default robot uses the most basic algorithm.
 * It places each item into the current box as long as it will fit in.</p>
 * <p>If it does not fit, the current box is closed and a new one is created</p>
 *
 */
public class DefaultRobot extends AbstractRobot {


    @Override
    public String pack(int[] items) {

        // only one box is used at any given time.
        stat.incOpenedBoxCount();
        StringBuilder boxes = new StringBuilder();
        int sum = 0;
        for (int item: items) {
            sum = sum + item;
            if (sum > CAPACITY) {

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
