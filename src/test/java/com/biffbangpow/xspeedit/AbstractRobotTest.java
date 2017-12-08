package com.biffbangpow.xspeedit;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AbstractRobotTest {

    @Test
    public void test_int_array_generation_is_successful() {

        int[] res = {1, 2, 3, 4, 5};
        assertEquals(AbstractRobot.of("12345"), res);
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
            AbstractRobot.of(input);
            fail("Should have raised IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), message);
        }
    }
}
