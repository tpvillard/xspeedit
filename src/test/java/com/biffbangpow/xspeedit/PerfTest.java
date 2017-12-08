package com.biffbangpow.xspeedit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Some performance tests to measure time complexity.
 */
public class PerfTest {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(PerfTest.class);

    private DefaultRobot defaultRobot = new DefaultRobot();
    private FirstFitRobot firstFitRobot = new FirstFitRobot();


    @Test
    public void measure_time_complexity() {

        int ratio = 100;
        int low = 1000;
        int high = low * ratio;

        Random random = new Random();
        int[] lowItems = generate(low, random);
        int[] highItems = generate(high, random);

        defaultRobot.doPack(lowItems);
        log(defaultRobot, low);
        firstFitRobot.doPack(lowItems);
        log(firstFitRobot, low);

        defaultRobot.doPack(highItems);
        log(defaultRobot, high);
        firstFitRobot.doPack(highItems);
        log(firstFitRobot, high);

        // Verify the algorithm is O(n)
        //assertApproximateEquals(largeTime / smallTime, ratio);
    }

    public void assertApproximateEquals(float actual, float expected) {
        double min = expected * 0.9;
        double max = expected * 1.1;
        assert (min <= actual && actual <= max);
    }

    private void log(AbstractRobot robot, int size) {
        LOGGER.info("{}, {}", size, robot.getStats());
    }

    private int[] generate(int size, Random random) {
        int[] res = new int[size];
        for (int i = 0; i < size ; i++) {
            res[i] = random.nextInt(9) + 1;
        }
        return res;
    }
}

