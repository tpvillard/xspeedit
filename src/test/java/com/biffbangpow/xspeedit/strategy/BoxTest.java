package com.biffbangpow.xspeedit.strategy;


import org.testng.Assert;
import org.testng.annotations.Test;

public class BoxTest {

    @Test
    public void test_box_is_full() {

        Box box = new Box();
        Assert.assertFalse(box.isFull());
        box.add(10);
        Assert.assertTrue(box.isFull());
    }

    @Test
    public void test_box_fir_for() {

        Box box = new Box();
        box.add(5);
        Assert.assertTrue(box.fitFor(5));
        Assert.assertFalse(box.fitFor(6));
    }
}
