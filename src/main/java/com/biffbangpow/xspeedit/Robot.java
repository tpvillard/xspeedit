package com.biffbangpow.xspeedit;

import com.biffbangpow.xspeedit.strategy.PackingStrategy;
import com.biffbangpow.xspeedit.strategy.Stat;

/**
 * A robot for packing items into boxes of a given capacity.
 */
public class Robot {

    private final PackingStrategy strategy;

    public Robot(PackingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Pack the items.
     * <p>Input format: a list of digits describing the items to pack and their weight</p>
     * <p>Output format: a list of boxes containing the packed items specified as a string with / separator</p>
     * <p>For instance: 5555 as input would return 55/55 ie two boxes containing 2 items of weight 5</p>
     *
     * @param input the items to pack specified as a string.
     * @return the packed items as a "/" separated string.
     */
    public String pack(String input) {

        return strategy.pack(of(input));
    }

    /**
     * Returns the stats.
     *
     * @return the stats
     */
    public Stat getStats() {
        return strategy.getStat();
    }

    /**
     * Generates an array of int from a string of digits.
     *
     * @param input the items to pack specified as a string of digits
     * @return the items to pack as an array of digits
     * @throws IllegalArgumentException when input parameter is in error
     */
    static int[] of(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input can't be null nor empty.");
        }

        char[] arr = input.toCharArray();
        int[] items = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            char elem = arr[i];
            if (Character.isDigit(elem)) {
                int item = Character.digit(elem, 10);
                if (item == 0) {
                    throw new IllegalArgumentException("Illegal digit 0 in " + input + ".");
                } else {
                    items[i] = item;
                }
            } else {
                throw new IllegalArgumentException("Illegal element " + arr[i] + " in " + input + ".");
            }
        }
        return items;
    }
}