package com.biffbangpow.xspeedit.strategy;

/**
 * An abstract packing strategy for packing items into boxes of a given capacity.
 */
public abstract class AbstractPackingStrategy implements PackingStrategy {

    /**
     * Some stats to measure performance.
     */
    protected Stat stat = new Stat();

    /**
     * Performs the pack operation.
     * @param items the items to pack
     * @return the packed items as a "/" separated string.
     */
    protected abstract String doPack(int[] items);

    @Override
    public String pack(int[] items) {

        // Create brand new stat for this run
        stat = new Stat();
        stat.setStartTime(System.nanoTime());
        String res = doPack(items);
        stat.setEndTime(System.nanoTime());
        return res;
    }

    @Override
    public Stat getStat() {
        return stat;
    }

}
