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
public abstract class AbstractFitStrategy extends AbstractPackingStrategy {

    protected abstract Box searchBox(int item, List<Box> openedBoxes);

    @Override
    public String doPack(int[] items) {

        List<Box> openedBoxes = new ArrayList<>();
        StringBuilder boxes = new StringBuilder();
        for (int item : items) {

            Box box = searchBox(item, openedBoxes);
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
        boxes.append(toString(openedBoxes));
        return boxes.toString();
    }

    private String toString(List<Box> boxes) {
        StringBuilder builder = new StringBuilder();
        for (Box box : boxes) {
            builder.append(box).append("/");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

    /**
     * A box.
     */
    static class Box {

        private final List<Integer> items = new ArrayList<>();
        private int sum = 0;

        private void add(int item) {
            items.add(item);
            sum = sum + item;
        }

        protected boolean fitFor(int item) {
            return sum + item <= BOX_CAPACITY;
        }

        private boolean isFull() {
            return sum == BOX_CAPACITY;
        }

        protected int getSpaceLeft() {
            return BOX_CAPACITY - sum;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Integer item : items) {
                builder.append(item);
            }
            return builder.toString();
        }
    }
}
