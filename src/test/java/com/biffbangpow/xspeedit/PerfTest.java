package com.biffbangpow.xspeedit;

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
 * O(1) < O(log(n)) < O(n) < O(n * log(n)) < O(n2) < O(n3) < O(kn) < etc...
 * FIXME ideally this class should not be run at each unit tests run...
 */
public class PerfTest {

    private int[] smallDataSet;
    private int[] largeDataSet;
    private int ratio = 100;

    @BeforeClass
    public void setUp() {

        int low = 1000;
        int high = low * ratio;

        Random random = new Random();
        smallDataSet = generate(low, random);
        largeDataSet = generate(high, random);
    }


    @Test
    public void measure_complexity_for_default_robot() {

        DefaultRobot robot = new DefaultRobot();
        MinMax minMax = doMeasure(robot);

        // Verify the algorithm is roughly O(n)
        assertApproximateEquals(minMax.largeTime / minMax.smallTime, ratio);
    }

    @Test
    public void measure_complexity_for_firstfit_robot() {

        FirstFitRobot robot = new FirstFitRobot();
        MinMax minMax = doMeasure(robot);

        // FIXME very unstable.
        // Verify the algorithm is roughly O(10n)
        // assertApproximateEquals(minMax.largeTime / minMax.smallTime, ratio * 10);
    }

    private MinMax doMeasure(AbstractRobot robot) {

        // Do several run to let the jvm performs optimization
        MinMax minMax = new MinMax();
        for (int i = 0; i < 10; i++) {
            robot.doPack(smallDataSet);
            log(robot, smallDataSet.length);
            minMax.smallTime = robot.getStats().getElapsedTime();

            robot.doPack(largeDataSet);
            log(robot, largeDataSet.length);
            minMax.largeTime = robot.getStats().getElapsedTime();
            System.out.println("ratio: " + minMax.largeTime / minMax.smallTime);
        }
        return minMax;
    }

    private void assertApproximateEquals(double actual, double expected) {
        double min = expected * 0.5;
        double max = expected * 1.5;
        Assert.assertTrue(min <= actual && actual <= max);
    }

    private void log(AbstractRobot robot, int size) {

        MessageFormat msg = new MessageFormat("Size {0}, {1}");
        Object[] args = {size, robot.getStats()};
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

