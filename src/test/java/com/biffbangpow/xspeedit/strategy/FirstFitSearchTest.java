package com.biffbangpow.xspeedit.strategy;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstFitSearchTest {

    @Test
    public void test_first_fit_is_returned() {

        FirstFitSearch search = new FirstFitSearch();
        List<Box> openedBoxes = new ArrayList<>();

        Box first = new Box();
        first.add(4);
        openedBoxes.add(first);

        Box second = new Box();
        second.add(8);
        openedBoxes.add(second);

        Assert.assertEquals(search.searchBox(2, openedBoxes), first);
    }
}
