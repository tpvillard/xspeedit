package com.biffbangpow.xspeedit;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DefaultRobotTest {

    private DefaultRobot robot = new DefaultRobot();

    @Test
    public void test_default_robot_conforms_to_spec() {
        assertEquals(robot.pack("163841689525773"), "163/8/41/6/8/9/52/5/7/73");
    }
}
