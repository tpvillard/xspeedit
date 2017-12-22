package com.biffbangpow.xspeedit.strategy;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TreeMultimapTest {

    private TreeMultimap<Integer, String> map;

    @BeforeMethod
    public void setUp() {
        map = new TreeMultimap<>();
    }

    @Test
    public void should_return_first_value_for_the_key() {

        map.put(1, "1");
        map.put(1, "2");
        Assert.assertEquals(map.get(1), "1");
    }

    @Test
    public void should_remove_mapping_for_the_key() {
        map.put(1, "1");
        Assert.assertEquals(map.remove(1, "1"), true);
        Assert.assertNull(map.get(1));
    }

    @Test
    public void should_return_ceiling_key_for_the_5() {

        map.put(1, "1");
        map.put(3, "3");
        map.put(5, "3");
        map.put(7, "3");
        Assert.assertEquals((int)map.ceilingKey(6), 7);
        Assert.assertEquals((int)map.ceilingKey(5), 5);
    }
}
