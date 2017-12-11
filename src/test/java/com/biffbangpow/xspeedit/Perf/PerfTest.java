package com.biffbangpow.xspeedit.Perf;

import com.biffbangpow.xspeedit.strategy.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.MessageFormat;
import java.util.Random;

/**
 * Some performance tests to measure time complexity.
 * <p>
 * The idea is to rank the algorithm time complexity:
 * <p>
 * O(1) < O(log(n)) < O(n) < O(n * log(n)) < O(n2) < O(n3) < O(nk) < etc...
 * FIXME ideally this class should not be run at each unit tests run...
 */
public class PerfTest {

    private int[] smallDataSet;
    private int[] largeDataSet;
    private int ratio = 10;

    @BeforeClass
    public void setUp() {

        int low = 1000;
        int high = low * ratio;

        Random random = new Random();
        smallDataSet = generate(low, random);
        largeDataSet = generate(high, random);
    }

    @Test
    public void measure_complexity_for_default_strategy() {

        DefaultPackingStrategy strategy = new DefaultPackingStrategy();
        float estimation = doMeasure(strategy);

        // Verify the algorithm is below O(n log (n))
        assertBelow(estimation, ratio * Math.log(ratio));
    }

    @Test
    public void measure_complexity_for_first_fit_strategy() {

        BestFirstFitStrategy strategy = new BestFirstFitStrategy(new FirstFitSearch());
        float estimation = doMeasure(strategy);

        // Verify the algorithm is below O(n2)
        assertBelow(estimation, ratio * ratio);
    }

    @Test
    public void measure_complexity_for_best_fit_robot() {

        BestFirstFitStrategy strategy = new BestFirstFitStrategy(new BestFitSearch());
        float estimation = doMeasure(strategy);

        assertBelow(estimation, ratio * ratio);
    }

    private float doMeasure(PackingStrategy strategy) {

        // Do several run to let the jvm performs optimization
        MinMax minMax = new MinMax();
        for (int i = 0; i < 200; i++) {
            strategy.pack(smallDataSet);
            log(strategy, smallDataSet.length);
            minMax.smallTime = minMax.smallTime + strategy.getStat().getElapsedTime();

            strategy.pack(largeDataSet);
            log(strategy, largeDataSet.length);
            minMax.largeTime =  minMax.largeTime + strategy.getStat().getElapsedTime();
            System.out.println("ratio: " + minMax.largeTime / minMax.smallTime);
        }
        return minMax.largeTime / minMax.smallTime;
    }

    private void assertBelow(double actual, double expected) {
        Assert.assertTrue(actual <= expected);
    }

    private void log(PackingStrategy strategy, int size) {

        MessageFormat msg = new MessageFormat("Size {0}, {1}");
        Object[] args = {size, strategy.getStat()};
        System.out.println(msg.format(args));
    }

    private int[] generate(int size, Random random) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = random.nextInt(9) + 1;
        }
        return res;
    }

    private static class MinMax {
        float smallTime;
        float largeTime;
    }
}

