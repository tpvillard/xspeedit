package com.biffbangpow.xspeedit;

import com.biffbangpow.xspeedit.strategy.*;

/**
 * A robot for packing items into boxes of a given capacity.
 */
public class Robot {

    private final PackingStrategy strategy;

    public Robot(PackingStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Pack the items.
     * <p>Input format: a list of digits describing the items to pack and their weight</p>
     * <p>Output format: a list of boxes containing the packed items specified as a string with / separator</p>
     * <p>For instance: 5555 as input would return 55/55 ie two boxes containing 2 items of weight 5</p>
     *
     * @param input the items to pack specified as a string.
     * @return the packed items as a "/" separated string.
     */
    public String pack(String input) {

        return strategy.pack(of(input));
    }

    /**
     * Returns the stats.
     *
     * @return the stats
     */
    private Stat getStats() {
        return strategy.getStat();
    }

    /**
     * Generates an array of int from a string of digits.
     *
     * @param input the items to pack specified as a string of digits
     * @return the items to pack as an array of digits
     * @throws IllegalArgumentException when input parameter is in error
     */
    protected static int[] of(String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input can't be null nor empty.");
        }

        char[] arr = input.toCharArray();
        int[] items = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            char elem = arr[i];
            if (Character.isDigit(elem)) {
                int item = Character.digit(elem, 10);
                if (item == 0) {
                    throw new IllegalArgumentException("Illegal digit 0 in " + input + ".");
                } else {
                    items[i] = item;
                }
            } else {
                throw new IllegalArgumentException("Illegal element " + arr[i] + " in " + input + ".");
            }
        }
        return items;
    }

    /**
     * Main entry point.
     * @param args the input to pack.
     */
    public static void main(String[] args) {

        String input;
        if (args.length == 0) {
            input = "163841689525773";
        } else {
            input = args[0];
        }

        Robot robot = Robot.newBestFitRobot();
        try {
            System.out.println("Packing: " + input);
            System.out.println(robot.pack(input));
            System.out.println(robot.getStats());
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * creates a robot with the default packing strategy.
     * @return the robot
     */
    public static Robot newDefautRobot() {
        return new Robot(new DefaultPackingStrategy());
    }

    /**
     * creates a robot with the first fit packing strategy.
     * @return the robot
     */
    public static Robot newFirstFitRobot() {
        return new Robot(new FitStrategy(new FirstFitSearch()));
    }

    /**
     * creates a robot with the best fit packing strategy.
     * @return the robot
     */
    public static Robot newBestFitRobot() {
        return new Robot(new FitStrategy(new BestFitSearch()));
    }
}
