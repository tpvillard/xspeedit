package com.biffbangpow.xspeedit.strategy;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BestFirstFitStrategyTest {

    private BestFirstFitStrategy bestFirstFit;
    private SearchBoxStrategy searchStrategy = mock(SearchBoxStrategy.class);
    private List<Box> openedBoxes = new ArrayList<>();

    @BeforeMethod
    public void setUp() {
        openedBoxes.clear();
    }

    @Test
    public void test_a_box_is_created() {

        bestFirstFit = new BestFirstFitStrategy(searchStrategy);
        when(searchStrategy.searchBox(1, openedBoxes)).thenReturn(null);

        bestFirstFit.treatItem(openedBoxes, new StringBuilder(), 1);

        Assert.assertTrue(openedBoxes.size() == 1);
        Assert.assertTrue(bestFirstFit.getStat().getBoxCount() == 1);
    }

    @Test
    public void test_full_box_is_removed_and_output() {

        Box box = new Box();
        box.add(7);
        openedBoxes.add(box);
        bestFirstFit = new BestFirstFitStrategy(searchStrategy);
        when(searchStrategy.searchBox(3, openedBoxes)).thenReturn(box);

        StringBuilder output = new StringBuilder();
        bestFirstFit.treatItem(openedBoxes, output, 3);

        Assert.assertTrue(openedBoxes.size() == 0);
        Assert.assertEquals(output.toString(), "73/");
    }
}
