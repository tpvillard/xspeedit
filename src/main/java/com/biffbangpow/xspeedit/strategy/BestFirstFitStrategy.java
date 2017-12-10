package com.biffbangpow.xspeedit.strategy;


import java.util.ArrayList;
import java.util.List;

/**
 * An abstract packing strategy for best/first fit algorithm.
 * <p>
 * <p>The boxes are kept opened as long as their capacity has not been reached.
 * The robot hence holds a list of opened box.</p>
 * <p>for each new item:</p>
 * <p>Search for a box in the opened box list in which the item will fit</p>
 * <p>Create a new box if no box is found. Add it to the opened box list</p>
 * <p>When a box gets full, the box is removed from the opened box list and ready for output</p>
 * <p>We sacrifice space for optimization.</p>
 */
public class BestFirstFitStrategy extends AbstractPackingStrategy {

    private final SearchBoxStrategy searchStrategy;

    public BestFirstFitStrategy(SearchBoxStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    @Override
    public String doPack(int[] items) {

        List<Box> openedBoxes = new ArrayList<>();
        StringBuilder boxes = new StringBuilder();
        for (int item : items) {

            treatItem(openedBoxes, boxes, item);
        }
        boxes.append(toString(openedBoxes));
        return boxes.toString();
    }

    void treatItem(List<Box> openedBoxes, StringBuilder boxes, int item) {
        Box box = searchStrategy.searchBox(item, openedBoxes);
        if (box == null) {
            stat.incBoxCount();
            stat.incOpenedBoxCount();
            box = new Box();
            openedBoxes.add(box);
        }
        box.add(item);
        if (box.isFull()) {
            stat.decOpenedBoxCount();
            openedBoxes.remove(box);
            boxes.append(box).append("/");
        }
    }

    private String toString(List<Box> boxes) {
        StringBuilder builder = new StringBuilder();
        for (Box box : boxes) {
            builder.append(box).append("/");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}
