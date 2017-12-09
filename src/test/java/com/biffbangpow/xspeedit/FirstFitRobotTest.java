package com.biffbangpow.xspeedit;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstFitRobotTest {

    private FirstFitRobot robot = new FirstFitRobot();

    @Test
    public void test_first_fit_robot_conforms_to_spec() {
        // Not bad but not really what is expected: 163/82/46/19/8/55/73/7
        assertEquals(robot.pack("163841689525773"), "163/46/82/55/73/81/9/7");
    }
}
