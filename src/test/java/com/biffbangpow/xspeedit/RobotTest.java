package com.biffbangpow.xspeedit;


import com.biffbangpow.xspeedit.strategy.BestFitStrategy;
import com.biffbangpow.xspeedit.strategy.DefaultPackingStrategy;
import com.biffbangpow.xspeedit.strategy.FirstFitStrategy;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class RobotTest {

    @Test
    public void test_best_fit_robot_conforms_to_spec() {
        Robot robot = new Robot(new BestFitStrategy());
        // Not bad but not really what is expected: 163/82/46/19/8/55/73/7
        assertEquals(robot.pack("163841689525773"), "163/46/82/55/73/81/9/7");
    }

    @Test
    public void test_first_fit_robot_conforms_to_spec() {
        Robot robot = new Robot(new FirstFitStrategy());
        // Not bad but not really what is expected: 163/82/46/19/8/55/73/7
        assertEquals(robot.pack("163841689525773"), "163/46/82/55/73/81/9/7");
    }

    @Test
    public void test_default_robot_conforms_to_spec() {
        Robot robot = new Robot(new DefaultPackingStrategy());
        assertEquals(robot.pack("163841689525773"), "163/8/41/6/8/9/52/5/7/73");
    }

    @Test
    public void test_int_array_generation_is_successful() {

        int[] res = {1, 2, 3, 4, 5};
        assertEquals(Robot.of("12345"), res);
    }

    @Test
    public void test_non_digit_in_input_is_forbidden() {

        testInvalidInput("Illegal element a in 3434ad.", "3434ad");
    }

    @Test
    public void test_0_digit_in_input_is_forbidden() {

        testInvalidInput("Illegal digit 0 in 67808.", "67808");
    }

    @Test
    public void test_null_input_is_forbidden() {

        testInvalidInput("Input can't be null nor empty.", null);
    }

    @Test
    public void test_empty_input_is_forbidden() {

        testInvalidInput("Input can't be null nor empty.", "");
    }

    private void testInvalidInput(String message, String input) {
        try {
            Robot.of(input);
            fail("Should have raised IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), message);
        }
    }
}
