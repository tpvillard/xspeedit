package com.biffbangpow.xspeedit.strategy;

/**
 * An interface for packing items into boxes of a given capacity.
 */
public interface PackingStrategy {

    /**
     * Pack the items.
     *
     * @param items the items to pack specified as an array of int.
     * @return the packed items as a "/" separated string.
     */
     String pack(int[] items);

    /**
     * Returns the statistics gathered when the strategy is run.
     * @return the statistics
     */
    Stat getStat();
}
