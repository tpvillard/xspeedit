package com.biffbangpow.xspeedit;


import java.util.ArrayList;
import java.util.List;

/**
 * A robot implementing first fit algorithm.
 *
 * <p>The boxes are kept opened as long as their capacity has not been reached.
 * The robot hence holds a list of opened box.</p>
 * <p>for each new item:</p>
 * <p>Search for a box in the opened box list in which the item will fit. The first box found is used.</p>
 * <p>Create a new box if no box is found. Add it to the opened box list</p>
 * <p>When a box gets full (no space left), the box is removed from the opened box list and ready for output</p>
 * <p>We sacrifice space complexity for optimization.</p>
 * <p>The algo is supposed to be better when entries are sorted but an online system
 * would not allow that.</p>
 *
 */
public class FirstFitRobot extends AbstractRobot {

    @Override
    public String pack(int[] items) {

        List<Box> openedBoxes = new ArrayList<>();
        StringBuilder boxes = new StringBuilder();
        for (int item : items) {

            Box box = searchFirstFit(item, openedBoxes);
            if (box == null) {
                stat.incBoxCount();
                box = new Box();
                openedBoxes.add(box);
            }
            box.add(item);
            if (box.isFull()) {
                // This optimization speeds up the search process
                openedBoxes.remove(box);
                boxes.append(box).append("/");
            }
        }
        boxes.append(toString(openedBoxes));
        return boxes.toString();
    }

    /**
     * Returns the first box in which the item can fit.
     * @param item the item to pack
     * @param boxes the list of opened boxes
     * @return the box or null if no box is found
     */
    private Box searchFirstFit(int item, List<Box> boxes) {

        Box found = null;
        for (Box box : boxes) {
            if (box.fitFor(item)) {
                found = box;
                break;
            }
        }
        return found;
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
    private static class Box {

        List<Integer> items = new ArrayList<>();
        int sum = 0;

        void add(int item) {
            items.add(item);
            sum = sum + item;
        }

        boolean fitFor(int item) {
            return sum + item <= CAPACITY;
        }

        boolean isFull() {
            return sum == CAPACITY;
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
