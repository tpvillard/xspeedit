package com.biffbangpow.xspeedit;

/**
 * Statistics for algo performance.
 */
public class Stat {

    private int boxCount;
    private long startTime;
    private long endTime;

    public int getBoxCount() {
        return boxCount;
    }

    public void incBoxCount() {
        boxCount++;
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
                ", elapsedTime=" + getElapsedTime() +
                '}';
    }
}
