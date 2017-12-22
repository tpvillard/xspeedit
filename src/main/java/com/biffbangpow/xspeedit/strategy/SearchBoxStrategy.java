package com.biffbangpow.xspeedit.strategy;

import java.util.List;
import java.util.Optional;

/**
 * An interface for searching a box in a list of boxes in which an item can fit.
 * The interface is used for best fit or first fit strategy.
 */
public interface SearchBoxStrategy {


    /**
     * Search for a box in the list of box in which the item can fit.
     * @param item the item to put in the box
     * @param boxes the list of boxes
     * @return a box or null if no box can be found
     */
    Box searchBox(int item, List<Box> boxes);
}
