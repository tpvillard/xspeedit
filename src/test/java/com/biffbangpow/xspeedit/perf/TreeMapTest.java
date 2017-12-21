package com.biffbangpow.xspeedit.perf;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.TreeMap;

public class TreeMapTest {

    TreeMap<Integer, String> map;

    @BeforeMethod
    public void setUp() {
        map = new TreeMap<>();
        map.put(1, "1");
        map.put(4, "4");
        map.put(6, "6");
        map.put(10, "10");
    }

    @Test
    public void should_return_6_as_ceiling_key_for_5() {
        Assert.assertEquals((int)map.ceilingKey(5), 6);
    }

    @Test
    public void should_return_6_as_ceiling_key_for_6() {
        Assert.assertEquals((int)map.ceilingKey(6), 6);
    }

    @Test
    public void should_return_6_as_floor_key_for_6() {
        Assert.assertEquals((int)map.floorKey(6), 6);
    }

    @Test
    public void should_return_4_as_floor_key_for_5() {
        Assert.assertEquals((int)map.floorKey(5), 4);
    }
}
