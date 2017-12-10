package com.biffbangpow.xspeedit;

/**
 * Statistics for algo performance.
 *
 * <p>We track:</p>
 * <p>Box count: the number of box used</p>
 * <p>Max opened box count: the maximum number of opened boxes while the algorithm is running.
 * This gives an indication of space complexity for the algorithm.</p>
 * <p>elapsed time: time used to resolve the problem.</p>
 */
public class Stat {

    private int boxCount;
    private int openedBoxCount;
    private int maxOpenedBoxCount;
    private long startTime;
    private long endTime;


    public void incBoxCount() {
        boxCount++;
    }

    public void incOpenedBoxCount() {
        openedBoxCount++;
        if (openedBoxCount > maxOpenedBoxCount) {
            maxOpenedBoxCount = openedBoxCount;
        }
    }

    public void decOpenedBoxCount() {
        openedBoxCount--;
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "boxCount=" + boxCount +
                ", maxOpenedBoxCount=" + maxOpenedBoxCount +
                ", elapsedTime=" + getElapsedTime() +
                '}';
    }
}
