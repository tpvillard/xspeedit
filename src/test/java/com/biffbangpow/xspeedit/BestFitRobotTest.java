package com.biffbangpow.xspeedit;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BestFitRobotTest {

    private BestFitRobot robot = new BestFitRobot();

    @Test
    public void test_best_fit_robot_conforms_to_spec() {
        // Not bad but not really what is expected: 163/82/46/19/8/55/73/7
        assertEquals(robot.pack("163841689525773"), "163/46/82/55/73/81/9/7");
    }
}
